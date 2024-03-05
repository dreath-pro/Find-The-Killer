package com.example.findthekiller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    ArrayList<PlayerModel> playerModels = new ArrayList<>();
    ArrayList<Characters> character = new ArrayList<>();
    ArrayList<String> role = new ArrayList<>();
    Random random = new Random();

    RecyclerView playerRecyclerView;
    TextView lineupPrompt;
    Button skipButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lineup);

        playerRecyclerView = findViewById(R.id.playerRecyclerView);
        lineupPrompt = findViewById(R.id.lineupPrompt);
        skipButton = findViewById(R.id.skipButton);

        addCharacter();
        for (int i = 0; i <= 7; i++) {
            int characterSelection = random.nextInt(character.size());

            playerModels.add(new PlayerModel(character.get(characterSelection).getName(), character.get(characterSelection).getGender(), null,
                    character.get(characterSelection).getCloseView(), character.get(characterSelection).getDeadImage(), character.get(characterSelection).getCloseView()));

            character.remove(characterSelection);
        }

        addRoles();
        int countKiller = 0;

        int killerLength = 0;
        for(String selectedRole : role)
        {
            if(selectedRole.equals("killer"))
            {
                killerLength++;
            }
        }

        for(int i = 0; i <= killerLength - 1; i++)
        {
            int playerSelection = random.nextInt(playerModels.size());
            while(playerModels.get(playerSelection).getRole() != null)
            {
                playerSelection = random.nextInt(playerModels.size());
            }

            playerModels.get(playerSelection).setRole(role.get(role.indexOf("killer")));
            countKiller++;
            role.remove("killer");
        }

        for(PlayerModel playerModel : playerModels)
        {
            if(playerModel.getRole() == null)
            {
                int selectedRole = random.nextInt(2);
                if(selectedRole == 0)
                {
                    playerModel.setRole(role.get(role.indexOf("family")));
                }else
                {
                    playerModel.setRole(role.get(role.indexOf("guest")));
                }
            }
        }

        if(countKiller == 0)
        {
            lineupPrompt.setText("There are no killer among them");
        }else if(countKiller == 1)
        {
            lineupPrompt.setText("There are " + countKiller + " killer among them");
        }else if(countKiller > 1)
        {
            lineupPrompt.setText("There are " + countKiller + " killers among them");
        }

        PlayerAdapter playerAdapter = new PlayerAdapter(this, playerModels);
        playerRecyclerView.setAdapter(playerAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.HORIZONTAL, false);
        playerRecyclerView.setLayoutManager(layoutManager);

        character.clear();
        role.clear();

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameActivity();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lineupLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void gameActivity()
    {
        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void addRoles()
    {
        for(int i = 1; i <= 2; i++)
        {
            role.add("killer");
        }

        for(int i = 0; i <= playerModels.size(); i++)
        {
            role.add("family");
            role.add("guest");
        }
    }

    private void addCharacter() {
        character.add(new Characters(R.drawable.player, R.drawable.player, "Dreath", "male"));
        character.add(new Characters(R.drawable.player, R.drawable.player, "Liam", "male"));
        character.add(new Characters(R.drawable.player, R.drawable.player, "Kiwi", "female"));
        character.add(new Characters(R.drawable.player, R.drawable.player, "Jade", "female"));
        character.add(new Characters(R.drawable.player, R.drawable.player, "Caleb", "male"));
        character.add(new Characters(R.drawable.player, R.drawable.player, "John", "male"));
        character.add(new Characters(R.drawable.player, R.drawable.player, "Princess", "female"));
        character.add(new Characters(R.drawable.player, R.drawable.player, "Kaz", "female"));
    }
}
