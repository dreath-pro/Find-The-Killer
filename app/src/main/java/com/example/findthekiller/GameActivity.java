package com.example.findthekiller;

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

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    TextView chatBox;
    TextView survivorNumber, killerNumber;
    Button inspectButton, suspectButton, askButton, quitButton;
    RecyclerView playerInterrogation;

    private SpannableStringBuilder builder = new SpannableStringBuilder();
    private Random random = new Random();

    private ArrayList<SpannableStringBuilder> conversation = new ArrayList<>();
    private ArrayList<PlayerModel> playerModels = new ArrayList<>();
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

        InterrogationAdapter interrogationAdapter = new InterrogationAdapter(this, playerModels, chatBox, conversation, this);
        playerInterrogation.setAdapter(interrogationAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        playerInterrogation.setLayoutManager(layoutManager);

        selectedPlayer = playerModels.get(0);
        selectedIndex = 0;

        for (int i = 0; i <= playerModels.size() - 1; i++) {
            conversation.add(new SpannableStringBuilder());
            initializeGreeting(i);
        }
        chatBox.setText(conversation.get(0));
        updatePlayerCount(false);

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
                if(survivorCount <= 1)
                {
                    //triggers lose fragment
                    componentActivation(false);
                    afterGame(false);
                }else if(killerCount == 0)
                {
                    //triggers win fragment
                    componentActivation(false);
                    afterGame(true);
                }else
                {
                    showSuspectResult();

                    indexValidation();
                    while(playerModels.get(selectedIndex).isEliminated())
                    {
                        indexValidation();
                    }
                    selectedPlayer = playerModels.get(selectedIndex);
                    chatBox.setText(conversation.get(selectedIndex));
                }
            }
        });

        askButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addQuestion(selectedIndex);
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

    @Override
    public void onBackPressed()
    {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    private void showSuspectResult()
    {
        Fragment eliminationFragment = new EliminationFragment(selectedPlayer);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.gameLayout, eliminationFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void afterGame(boolean isWinning)
    {
        ArrayList<PlayerModel> killerLists = new ArrayList<>();
        for(PlayerModel playerList : playerModels)
        {
            if(playerList.getRole().equals("Killer"))
            {
                killerLists.add(playerList);
            }
        }
        Fragment aftergameFragment = new AftergameFragment(killerLists, isWinning);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.gameLayout, aftergameFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void componentActivation(boolean activate)
    {
        inspectButton.setEnabled(activate);
        suspectButton.setEnabled(activate);
        askButton.setEnabled(activate);
    }

    private void indexValidation()
    {
        if((selectedIndex + 1) > (playerModels.size() - 1))
        {
            selectedIndex = 0;
        }else
        {
            selectedIndex++;
        }
    }

    public void updatePlayerCount(boolean toEliminate)
    {
        if(!toEliminate)
        {
            for(PlayerModel players : playerModels)
            {
                if(!players.isEliminated())
                {
                    if(players.getRole().equals("Killer"))
                    {
                        killerCount++;
                    }else
                    {
                        survivorCount++;
                    }
                }
            }
        }else
        {
            if(selectedPlayer.getRole().equals("Killer"))
            {
                killerCount--;
            }else
            {
                survivorCount--;
            }

            if(killerCount < 0)
            {
                killerCount = 0;
            }
            if(survivorCount < 0)
            {
                survivorCount = 0;
            }
        }

        survivorNumber.setText("" + survivorCount);
        killerNumber.setText("" + killerCount);
    }

    public void setSelectedPlayer(PlayerModel selectedPlayer) {
        GameActivity.selectedPlayer = selectedPlayer;
    }

    public void setSelectedIndex(int selectedIndex)
    {
        GameActivity.selectedIndex = selectedIndex;
    }

    private void addQuestion(int selectedPlayer) {
        conversation.get(selectedPlayer).append("You: Hey haha you are cute muah! wanna play some other time " + playerModels.get(selectedPlayer).getName() + "?");
        conversation.get(selectedPlayer).setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_NORMAL), 0, builder.length(), 0);

        conversation.get(selectedPlayer).append("\n\n");

        chatBox.setText(conversation.get(selectedIndex));
    }

    private void initializeGreeting(int selectedPlayer) {
        int selectGreeting = random.nextInt(12);
        switch (selectGreeting) {
            case 0:
                conversation.get(selectedPlayer).append(playerModels.get(selectedPlayer).getName() + ": Hi there, my name is " + playerModels.get(selectedPlayer).getName() + ". Feel free to ask me any questions!");
                break;
            case 1:
                conversation.get(selectedPlayer).append(playerModels.get(selectedPlayer).getName() + ": Hey! I'm " + playerModels.get(selectedPlayer).getName() + ", here to answer any questions you might have.");
                break;
            case 2:
                conversation.get(selectedPlayer).append(playerModels.get(selectedPlayer).getName() + ": Hello, there! " + playerModels.get(selectedPlayer).getName() + " here, ready for your curious inquiries.");
                break;
            case 3:
                conversation.get(selectedPlayer).append(playerModels.get(selectedPlayer).getName() + ": Greetings! It's " + playerModels.get(selectedPlayer).getName() + ", feel free to shoot me any questions your heart desires.");
                break;
            case 4:
                conversation.get(selectedPlayer).append(playerModels.get(selectedPlayer).getName() + ": Hi there, " + playerModels.get(selectedPlayer).getName() + " at your service! Ask away, and let's have a chat.");
                break;
            case 5:
                conversation.get(selectedPlayer).append(playerModels.get(selectedPlayer).getName() + ": Yo, what's up? " + playerModels.get(selectedPlayer).getName() + " in the house, hit me up with your questions!");
                break;
            case 6:
                conversation.get(selectedPlayer).append(playerModels.get(selectedPlayer).getName() + ": Howdy, it's " + playerModels.get(selectedPlayer).getName() + "! Ask away, and let's dive into some intriguing conversations!");
                break;
            case 7:
                conversation.get(selectedPlayer).append(playerModels.get(selectedPlayer).getName() + ": Top of the day to ya! I'm " + playerModels.get(selectedPlayer).getName() + ", your friendly stranger question-answerer. Fire away!");
                break;
            case 8:
                conversation.get(selectedPlayer).append(playerModels.get(selectedPlayer).getName() + ": Hey, hey! " + playerModels.get(selectedPlayer).getName() + " in the building, ready for the ultimate Q&A showdown. What's your move?");
                break;
            case 9:
                conversation.get(selectedPlayer).append(playerModels.get(selectedPlayer).getName() + ": Greetings and salutations! It's " + playerModels.get(selectedPlayer).getName() + ", your go-to guy for all things questions. Lay 'em on me!");
                break;
            case 10:
                conversation.get(selectedPlayer).append(playerModels.get(selectedPlayer).getName() + ": Yo, it's " + playerModels.get(selectedPlayer).getName() + "! Drop your questions like they're hot!");
                break;
            case 11:
                conversation.get(selectedPlayer).append(playerModels.get(selectedPlayer).getName() + ": What's kickin', amigo? I'm " + playerModels.get(selectedPlayer).getName() + ", throw your questions at me!");
                break;
        }
        conversation.get(selectedPlayer).setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_NORMAL), 0, builder.length(), 0);
        conversation.get(selectedPlayer).append("\n\n");
    }
}
