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
import com.example.findthekiller.model.rooms.Porch1;

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

//                survivorMove();
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

    private void survivorMove() {
        int roomSelected = random.nextInt(rooms.size());
        int selectedPerson = random.nextInt(playerModels.size());
        int numberOfPerson = 0;
        int socialize = 1;

        String room, activity;
        boolean firstNonGroup = false;
        double reducedSurvivorCount = survivorCount * .30;

        chatBox.setText(conversation.get(selectedIndex));
        /**
         * socialize
         * 1 = alone
         * 2 = duo/partner
         * 3 = 3 or more people
         */

        for(int i = 0; i <= playerModels.size() - 1; i++)
        {
            playerModels.get(i).clearGroup();
            playerModels.get(i).setRoom("");
            playerModels.get(i).setActivity("");
        }

        for (int i = 0; i <= playerModels.size() - 1; i++) {
            if(!firstNonGroup)
            {
                if(!playerModels.get(i).getRole().equals("Killer"))
                {
                    firstNonGroup = true;
                }
            }

            if (!playerModels.get(i).isEliminated()) {
                if(playerModels.get(i).getGroups().isEmpty())
                {
                    socialize = random.nextInt(3) + 1;
                    switch (socialize) {
                        case 1:
                            numberOfPerson = 0;
                            break;
                        case 2:
                            numberOfPerson = 1;
                            break;
                        case 3:
                            numberOfPerson = random.nextInt((int)reducedSurvivorCount) + 2;
                            break;
                    }

                    roomSelected = random.nextInt(rooms.size());
                    room = rooms.get(roomSelected).getRoomName();
                    activity = rooms.get(roomSelected).getActivity();

                    for (int j = 1; j <= numberOfPerson; j++) {
                        selectedPerson = random.nextInt(playerModels.size());

                        if(firstNonGroup)
                        {
                            while (playerModels.get(i).getName().equals(playerModels.get(selectedPerson).getName())
                                    || playerModels.get(selectedPerson).getRole().equals("Killer")
                                    || playerModels.get(selectedPerson).isEliminated())
                            {
                                selectedPerson = random.nextInt(playerModels.size());
                            }
                        }else
                        {
                            while (playerModels.get(i).getName().equals(playerModels.get(selectedPerson).getName())
                                    || playerModels.get(selectedPerson).getRole().equals("Killer")
                                    || playerModels.get(selectedPerson).isEliminated()
                                    || !playerModels.get(selectedPerson).getRoom().isEmpty()
                                    || !playerModels.get(selectedPerson).getActivity().isEmpty())
                            {
                                selectedPerson = random.nextInt(playerModels.size());
                            }
                        }

                        playerModels.get(i).addGroup(playerModels.get(selectedPerson));

                        if(!playerModels.get(i).getRole().equals("Killer"))
                        {
                            if(!playerModels.get(i).getGroups().isEmpty())
                            {
                                for(int groupIdx = 0; groupIdx <= playerModels.get(i).getGroups().size() - 1; groupIdx++)
                                {
                                    if(!Objects.equals(playerModels.get(selectedPerson).getName(), playerModels.get(i).getGroups().get(groupIdx).getName()))
                                    {
                                        playerModels.get(selectedPerson).addGroup(playerModels.get(i).getGroups().get(groupIdx));
                                    }
                                }
                            }
                            playerModels.get(selectedPerson).addGroup(playerModels.get(i));
                            playerModels.get(selectedPerson).setRoom(room);
                            playerModels.get(selectedPerson).setActivity(activity);
                        }
                    }

                    playerModels.get(i).setRoom(room);
                    playerModels.get(i).setActivity(activity);
                }
            }
        }
    }

    private void killerMove()
    {
        boolean isReported = false;

        while(!isReported)
        {
            survivorMove();
            for(int i = 0; i <= playerModels.size() - 1; i++)
            {
                if(!playerModels.get(i).getRole().equals("Killer"))
                {
                    if(playerModels.get(i).getGroups().isEmpty())
                    {
                        if(!playerModels.get(i).isEliminated())
                        {
                            if(survivorCount <= 1)
                            {
                                afterGame(false);
                            }else
                            {
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
    }
}
