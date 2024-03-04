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
    RecyclerView playerRecyclerView;
    ArrayList<Characters> character = new ArrayList<>();
    Random random = new Random();

    ArrayList<PlayerModel> playerModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lineup);

        playerRecyclerView = findViewById(R.id.playerRecyclerView);
        addImages();

        for (int i = 0; i <= 14; i++) {
            int selection = random.nextInt(character.size());

            playerModels.add(new PlayerModel(character.get(selection).getName(), character.get(selection).getGender(),
                    character.get(selection).getStandImage(), character.get(selection).getDeadImage(), character.get(selection).getCloseView()));

//            character.remove(selection);
        }

        PlayerAdapter playerAdapter = new PlayerAdapter(this, playerModels);
        playerRecyclerView.setAdapter(playerAdapter);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.HORIZONTAL, false);
        playerRecyclerView.setLayoutManager(layoutManager);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lineupLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addImages() {
        character.add(new Characters(R.drawable.player, R.drawable.player, R.drawable.player, "Silver", "male"));
    }
}
