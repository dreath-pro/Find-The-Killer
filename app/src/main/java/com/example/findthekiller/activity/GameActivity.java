package com.example.findthekiller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AlignmentSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findthekiller.fragment.AftergameFragment;
import com.example.findthekiller.fragment.EliminationFragment;
import com.example.findthekiller.adapter.InterrogationAdapter;
import com.example.findthekiller.model.HouseModel;
import com.example.findthekiller.model.MessageModel;
import com.example.findthekiller.model.PlayerModel;
import com.example.findthekiller.R;
import com.example.findthekiller.model.rooms.Entry;
import com.example.findthekiller.model.rooms.Garage1;
import com.example.findthekiller.model.rooms.Garage2;
import com.example.findthekiller.model.rooms.Porch1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    TextView chatBox;
    TextView survivorNumber, killerNumber;
    Button inspectButton, suspectButton, askButton, quitButton;
    RecyclerView playerInterrogation;

    private SpannableStringBuilder builder = new SpannableStringBuilder();
    private Random random = new Random();

    InterrogationAdapter interrogationAdapter;

    private ArrayList<SpannableStringBuilder> conversation = new ArrayList<>();
    private ArrayList<PlayerModel> playerModels = new ArrayList<>();
    private ArrayList<HouseModel> rooms = new ArrayList<>();
    private static PlayerModel selectedPlayer;
    private static int selectedIndex;
    private int survivorCount, killerCount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);

        playerInterrogation = findViewById(R.id.playerInterrogation);
        chatBox = findViewById(R.id.chatBox);
        survivorNumber = findViewById(R.id.survivorNumber);
        killerNumber = findViewById(R.id.killerNumber);
        inspectButton = findViewById(R.id.inspectButton);
        suspectButton = findViewById(R.id.suspectButton);
        askButton = findViewById(R.id.askButton);
        quitButton = findViewById(R.id.quitButton);

        playerModels = getIntent().getParcelableArrayListExtra("playerModels");

        interrogationAdapter = new InterrogationAdapter(this, playerModels, chatBox, conversation, this);
        playerInterrogation.setAdapter(interrogationAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        playerInterrogation.setLayoutManager(layoutManager);

        selectedPlayer = playerModels.get(0);
        selectedIndex = 0;

        for (int i = 0; i <= playerModels.size() - 1; i++) {
            conversation.add(new SpannableStringBuilder());
            conversation.get(i).append(new MessageModel(playerModels.get(i)).selectGreeting());
        }
        chatBox.setText(conversation.get(0));
        updatePlayerCount(false);
        initializeRoom();

        componentActivation(false);
        killerMove();
        componentActivation(true);

        inspectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assignSurvivors();
            }
        });

        suspectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerModels.get(selectedIndex).setEliminated(true);
                interrogationAdapter.notifyItemChanged(selectedIndex);

                updatePlayerCount(true);
                if (survivorCount <= 1) {
                    //triggers lose fragment
                    componentActivation(false);
                    afterGame(false);
                } else if (killerCount == 0) {
                    //triggers win fragment
                    componentActivation(false);
                    afterGame(true);
                } else {
                    showSuspectResult();
                    changeFocusChat();

                    componentActivation(false);
                    killerMove();
                    componentActivation(true);
                }
            }
        });

        askButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversation.get(selectedIndex).append(new MessageModel(playerModels.get(selectedIndex)).askQuestion());
                chatBox.setText(conversation.get(selectedIndex));
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.gameLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void changeFocusChat() {
        indexValidation();
        while (playerModels.get(selectedIndex).isEliminated()) {
            indexValidation();
        }
        selectedPlayer = playerModels.get(selectedIndex);
        chatBox.setText(conversation.get(selectedIndex));
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    private void showSuspectResult() {
        Fragment eliminationFragment = new EliminationFragment(selectedPlayer);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.gameLayout, eliminationFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void afterGame(boolean isWinning) {
        ArrayList<PlayerModel> killerLists = new ArrayList<>();
        for (PlayerModel playerList : playerModels) {
            if (playerList.getRole().equals("Killer")) {
                killerLists.add(playerList);
            }
        }
        Fragment aftergameFragment = new AftergameFragment(killerLists, isWinning);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.gameLayout, aftergameFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void componentActivation(boolean activate) {
        inspectButton.setEnabled(activate);
        suspectButton.setEnabled(activate);
        askButton.setEnabled(activate);
    }

    private void indexValidation() {
        if ((selectedIndex + 1) > (playerModels.size() - 1)) {
            selectedIndex = 0;
        } else {
            selectedIndex++;
        }
    }

    public void updatePlayerCount(boolean toEliminate) {
        if (!toEliminate) {
            for (PlayerModel players : playerModels) {
                if (!players.isEliminated()) {
                    if (players.getRole().equals("Killer")) {
                        killerCount++;
                    } else {
                        survivorCount++;
                    }
                }
            }
        } else {
            if (selectedPlayer.getRole().equals("Killer")) {
                killerCount--;
            } else {
                survivorCount--;
            }

            if (killerCount < 0) {
                killerCount = 0;
            }
            if (survivorCount < 0) {
                survivorCount = 0;
            }
        }

        survivorNumber.setText("" + survivorCount);
        killerNumber.setText("" + killerCount);
    }

    public void setSelectedPlayer(PlayerModel selectedPlayer) {
        GameActivity.selectedPlayer = selectedPlayer;
    }

    public void setSelectedIndex(int selectedIndex) {
        GameActivity.selectedIndex = selectedIndex;
    }

    private void isPlayerValid()
    {
        for(int i = 0; i <= playerModels.size() - 1; i++)
        {
            if (playerModels.get(i).getRole().equals("Killer")) {
                playerModels.get(i).setValid(false);
            }
            if (playerModels.get(i).isEliminated()) {
                playerModels.get(i).setValid(false);
            }
            if (!playerModels.get(i).getRoom().isEmpty()) {
                playerModels.get(i).setValid(false);
            }
            if (!playerModels.get(i).getActivity().isEmpty()) {
                playerModels.get(i).setValid(false);
            }
        }
    }

    private boolean isValidLow()
    {
        int validCount = 0;
        boolean result;

        for(PlayerModel playerModel : playerModels)
        {
            if(playerModel.isValid())
            {
                validCount++;
            }
        }
        if(validCount <= 1)
        {
            result = true;
        }else
        {
            result = false;
        }

        return result;
    }

    private void assignSurvivors() {
        int numberOfPerson = 0, selectedPerson = 0;
        int validCount = 0;
        String selectedRoom = "", selectedActivity = "";
        double reducedSurvivorCount = survivorCount * .20;

        for (int i = 0; i <= playerModels.size() - 1; i++) {
            playerModels.get(i).clearGroup();
            playerModels.get(i).setRoom("");
            playerModels.get(i).setActivity("");
            playerModels.get(i).setValid(true);

            for(HouseModel room : rooms)
            {
                room.setLock(false);
            }
        }

        isPlayerValid();

        for(int i = 0; i <= playerModels.size() - 1; i++)
        {
            if (playerModels.get(i).isValid()) {
                numberOfPerson = random.nextInt((int) reducedSurvivorCount);

                for(PlayerModel playerModel : playerModels)
                {
                    if(playerModel.isValid())
                    {
                        validCount++;
                    }
                }
                if(validCount <= 1)
                {
                    numberOfPerson = 0;
                }

                selectedPerson = random.nextInt(playerModels.size());
                while (playerModels.get(i).getName().equals(playerModels.get(selectedPerson).getName())
                    || !playerModels.get(selectedPerson).isValid()) {
                    if(isValidLow())
                    {
                        numberOfPerson = 0;
                        break;
                    }
                    selectedPerson = random.nextInt(playerModels.size());
                }

                int roomSelection = random.nextInt(rooms.size());
                while(rooms.get(roomSelection).isLock())
                {
                    roomSelection = random.nextInt(rooms.size());
                }
                selectedRoom = rooms.get(roomSelection).getRoomName();

                switch (numberOfPerson) {
                    case 0:
                        selectedActivity = rooms.get(roomSelection).getActivity(0);
                        break;
                    case 1:
                        if (!playerModels.get(i).getGender().equals(playerModels.get(selectedPerson).getGender())) {
                            int toPartner = random.nextInt(2);
                            if (toPartner == 0) {
                                if(isLockable(rooms.get(roomSelection).getRoomName()))
                                {
                                    rooms.get(roomSelection).setLock(true);
                                }
                                selectedActivity = rooms.get(roomSelection).getActivity(2);
                            } else {
                                selectedActivity = rooms.get(roomSelection).getActivity(1);
                            }
                        } else {
                            selectedActivity = rooms.get(roomSelection).getActivity(1);
                        }
                        break;
                    default:
                        selectedActivity = rooms.get(roomSelection).getActivity(3);
                        break;
                }

                for (int j = 1; j <= numberOfPerson; j++) {
                    while (playerModels.get(i).getName().equals(playerModels.get(selectedPerson).getName())
                            || !playerModels.get(selectedPerson).isValid()) {
                        if(isValidLow())
                        {
                            break;
                        }
                        selectedPerson = random.nextInt(playerModels.size());
                    }

                    playerModels.get(i).addGroup(playerModels.get(selectedPerson));
                    playerModels.get(selectedPerson).addGroup(playerModels.get(i));
                    for (int groupIdx = 0; groupIdx <= playerModels.get(i).getGroups().size() - 1; groupIdx++) {
                        if (!playerModels.get(selectedPerson).getName().equals(playerModels.get(i).getGroups().get(groupIdx).getName())) {
                            playerModels.get(selectedPerson).addGroup(playerModels.get(i).getGroups().get(groupIdx));
                            playerModels.get(i).getGroups().get(groupIdx).addGroup(playerModels.get(selectedPerson));
                        }
                    }

                    playerModels.get(selectedPerson).setActivity(selectedActivity);
                    playerModels.get(selectedPerson).setRoom(selectedRoom);

                    selectedPerson = random.nextInt(playerModels.size());
                }

                playerModels.get(i).setActivity(selectedActivity);
                playerModels.get(i).setRoom(selectedRoom);
            }
            isPlayerValid();
        }
    }

    private void killerMove() {
        boolean isReported = false;

        while (!isReported) {
            assignSurvivors();
            for (int i = 0; i <= playerModels.size() - 1; i++) {
                if (!playerModels.get(i).getRole().equals("Killer")) {
                    if (playerModels.get(i).getGroups().isEmpty()) {
                        if (!playerModels.get(i).isEliminated()) {
                            if (survivorCount <= 1) {
                                afterGame(false);
                            } else {
                                playerModels.get(i).setEliminated(true);
                                interrogationAdapter.notifyItemChanged(selectedIndex);

                                updatePlayerCount(true);
                                changeFocusChat();
                                isReported = true;

                                Toast.makeText(this, playerModels.get(i).getName() + "'s corpse been found!", Toast.LENGTH_SHORT).show();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private void initializeRoom() {
        rooms.add(new Entry());
        rooms.add(new Porch1());
        rooms.add(new Garage1());
        rooms.add(new Garage2());
    }

    private boolean isLockable(String room)
    {
        boolean isLockable = false;

        if(room.equals("first garage") || room.equals("second garage"))
        {
            isLockable = true;
        }

        return isLockable;
    }
}
