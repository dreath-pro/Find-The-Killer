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
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    TextView chatBox;
    TextView survivorNumber, killerNumber;
    Button investigateButton, suspectButton, askButton, quitButton;
    private RecyclerView playerInterrogation;

    private SpannableStringBuilder builder = new SpannableStringBuilder();
    private Random random = new Random();

    private ArrayList<SpannableStringBuilder> conversation = new ArrayList<>();
    private ArrayList<PlayerModel> playerModels = new ArrayList<>();
    private static PlayerModel selectedPlayer;
    private static int selectedIndex;
    private int survivorCount = 0, killerCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);

        playerInterrogation = findViewById(R.id.playerInterrogation);
        chatBox = findViewById(R.id.chatBox);
        survivorNumber = findViewById(R.id.survivorNumber);
        killerNumber = findViewById(R.id.killerNumber);
        investigateButton = findViewById(R.id.investigateButton);
        suspectButton = findViewById(R.id.suspectButton);
        askButton = findViewById(R.id.askButton);
        quitButton = findViewById(R.id.quitButton);

        playerModels = getIntent().getParcelableArrayListExtra("playerModels");

        InterrogationAdapter interrogationAdapter = new InterrogationAdapter(this, playerModels, chatBox, conversation);
        playerInterrogation.setAdapter(interrogationAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        playerInterrogation.setLayoutManager(layoutManager);

        selectedPlayer = playerModels.get(0);
        selectedIndex = 0;

        for (int i = 0; i <= playerModels.size() - 1; i++) {
            conversation.add(new SpannableStringBuilder());
            initializeGreeting(i);

            if(playerModels.get(i).getRole().equals("killer"))
            {
                killerCount++;
            }else
            {
                survivorCount++;
            }
        }
        survivorNumber.setText("" + survivorCount);
        killerNumber.setText("" + killerCount);
        chatBox.setText(conversation.get(0));

        investigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GameActivity.this, "The selected player is now: " + selectedPlayer.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        suspectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
        int selectGreeting = random.nextInt(6);
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
        }
        conversation.get(selectedPlayer).setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_NORMAL), 0, builder.length(), 0);
        conversation.get(selectedPlayer).append("\n\n");
    }
}
