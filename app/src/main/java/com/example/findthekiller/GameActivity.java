package com.example.findthekiller;

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
    Button investigateButton, suspectButton, askButton;

    private SpannableStringBuilder builder = new SpannableStringBuilder();
    private ArrayList<PlayerModel> playerModels = new ArrayList<>();
    private static PlayerModel selectedPlayer;
    private RecyclerView playerInterrogation;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);

        playerInterrogation = findViewById(R.id.playerInterrogation);
        chatBox = findViewById(R.id.chatBox);
        investigateButton = findViewById(R.id.investigateButton);
        suspectButton = findViewById(R.id.suspectButton);
        askButton = findViewById(R.id.askButton);

        builderMessages();
        chatBox.setText(builder);

        playerModels = getIntent().getParcelableArrayListExtra("playerModels");

        InterrogationAdapter interrogationAdapter = new InterrogationAdapter(this, playerModels);
        playerInterrogation.setAdapter(interrogationAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        playerInterrogation.setLayoutManager(layoutManager);

        selectedPlayer = playerModels.get(0);

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

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.gameLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void setSelectedPlayer(PlayerModel selectedPlayer)
    {
        this.selectedPlayer = selectedPlayer;
    }

    private void builderMessages()
    {
        builder.append("Caleb: Huwa, what u do?");
        builder.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE), 0, builder.length(), 0);

        builder.append("\n\n");

        builder.append("Kiwi: Hey haha you are cute muah! wanna play some other time caleb?");
        builder.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_NORMAL), builder.length() - 9, builder.length(), 0);
    }
}
