package com.example.findthekiller;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class LineupActivity extends AppCompatActivity {
    Random random = new Random();

    ArrayList<PlayerModel> playerModels = new ArrayList<>();
    int[][] tryLang = {{R.drawable.player, R.drawable.player},
            {R.drawable.player, R.drawable.player}};
    int[] playerImagesMale = {R.drawable.player};
    int[] playerImagesFemale = {R.drawable.player};

    String[] playerNamesMale = {"Silver", "Aves", "Tyler", "Jewrind"};
    String[] playerNamesFemale = {"Julie", "Blossom", "Ashley", "Ariel"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lineup);

        RecyclerView playerRecyclerView = findViewById(R.id.playerRecyclerView);
        for (int i = 0; i <= 7; i++) {
            int[] playerImages;
            String[] playerNames;

            int gender = random.nextInt(2);
            if (gender == 0) {
                playerImages = playerImagesMale;
                playerNames = playerNamesMale;
            } else {
                playerImages = playerImagesFemale;
                playerNames = playerNamesFemale;
            }

            playerModels.add(new PlayerModel(playerNames[random.nextInt(playerNames.length)], "male", playerImages[random.nextInt(playerImages.length)]));
        }

        PlayerAdapter playerAdapter = new PlayerAdapter(this, playerModels);
        playerRecyclerView.setAdapter(playerAdapter);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.HORIZONTAL, false);
        playerRecyclerView.setLayoutManager(layoutManager);
//        playerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        playerRecyclerView.setLayoutManager(layoutManager);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lineupLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
