package com.example.findthekiller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findthekiller.model.CharacterModel;
import com.example.findthekiller.adapter.PlayerAdapter;
import com.example.findthekiller.model.PlayerModel;
import com.example.findthekiller.R;

import java.util.ArrayList;
import java.util.Random;

public class LineupActivity extends AppCompatActivity {
    ArrayList<PlayerModel> playerModels = new ArrayList<>();
    ArrayList<CharacterModel> character = new ArrayList<>();
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
        for (int i = 1; i <= 16; i++) {
            int characterSelection = random.nextInt(character.size());

            playerModels.add(new PlayerModel(character.get(characterSelection).getName(), character.get(characterSelection).getGender(), null,
                  character.get(characterSelection).getImage()));

            character.remove(characterSelection);
        }

        addRoles();
        int countKiller = 0;

        int killerLength = 0;
        for(String selectedRole : role)
        {
            if(selectedRole.equals("Killer"))
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

            playerModels.get(playerSelection).setRole(role.get(role.indexOf("Killer")));
            countKiller++;
            role.remove("Killer");
        }

        for(PlayerModel playerModel : playerModels)
        {
            if(playerModel.getRole() == null)
            {
                int selectedRole = random.nextInt(2);
                if(selectedRole == 0)
                {
                    playerModel.setRole(role.get(role.indexOf("Family")));
                }else
                {
                    playerModel.setRole(role.get(role.indexOf("Guest")));
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
        intent.putExtra("playerModels", playerModels);
        startActivity(intent);
    }

    private void addRoles()
    {
        for(int i = 1; i <= 4; i++)
        {
            role.add("Killer");
        }

        for(int i = 0; i <= playerModels.size(); i++)
        {
            role.add("Family");
            role.add("Guest");
        }
    }

    private void addCharacter() {
        character.add(new CharacterModel(R.drawable.alice, "Alice", "Female"));
        character.add(new CharacterModel(R.drawable.alisson, "Alisson", "Female"));
        character.add(new CharacterModel(R.drawable.angel, "Angel", "Female"));
        character.add(new CharacterModel(R.drawable.bianca, "Bianca", "Female"));
        character.add(new CharacterModel(R.drawable.bryan, "Bryan", "Male"));
        character.add(new CharacterModel(R.drawable.cherry, "Cherry", "Female"));
        character.add(new CharacterModel(R.drawable.fatima, "Fatima", "Female"));
        character.add(new CharacterModel(R.drawable.francis, "Francis", "Female"));
        character.add(new CharacterModel(R.drawable.fritz, "Fritz", "Male"));
        character.add(new CharacterModel(R.drawable.jacob, "Jacob", "Male"));
        character.add(new CharacterModel(R.drawable.james, "James", "Male"));
        character.add(new CharacterModel(R.drawable.john, "John", "Male"));
        character.add(new CharacterModel(R.drawable.juliet, "Juliet", "Female"));
        character.add(new CharacterModel(R.drawable.kimberly, "Kimberly", "Female"));
        character.add(new CharacterModel(R.drawable.kyle, "Kyle", "Male"));
        character.add(new CharacterModel(R.drawable.lee, "Lee", "Male"));
        character.add(new CharacterModel(R.drawable.liam, "Liam", "Male"));
        character.add(new CharacterModel(R.drawable.louise, "Louise", "Female"));
        character.add(new CharacterModel(R.drawable.merry, "Merry", "Female"));
        character.add(new CharacterModel(R.drawable.nicolas, "Nicolas", "Male"));
        character.add(new CharacterModel(R.drawable.rachel, "Rachel", "Female"));
        character.add(new CharacterModel(R.drawable.sarah, "Sarah", "Female"));
        character.add(new CharacterModel(R.drawable.sasa, "Sasa", "Female"));
        character.add(new CharacterModel(R.drawable.steve, "Steve", "Male"));
        character.add(new CharacterModel(R.drawable.venus, "Venus", "Female"));
        character.add(new CharacterModel(R.drawable.vince, "Vince", "Male"));
        character.add(new CharacterModel(R.drawable.ryan, "Ryan", "Male"));
        character.add(new CharacterModel(R.drawable.elize, "Elize", "Female"));
        character.add(new CharacterModel(R.drawable.marie, "Marie", "Female"));
        character.add(new CharacterModel(R.drawable.grace, "Grace", "Female"));
        character.add(new CharacterModel(R.drawable.adrian, "Adrian", "Male"));
        character.add(new CharacterModel(R.drawable.lloyd, "Lloyd", "Male"));
        character.add(new CharacterModel(R.drawable.austin, "Austin", "Male"));
        character.add(new CharacterModel(R.drawable.nicole, "Nicole", "Female"));
        character.add(new CharacterModel(R.drawable.olivia, "Olivia", "Female"));
        character.add(new CharacterModel(R.drawable.marco, "Marco", "Male"));
        character.add(new CharacterModel(R.drawable.kathy, "Kathy", "Female"));
        character.add(new CharacterModel(R.drawable.mitch, "Mitch", "Female"));
        character.add(new CharacterModel(R.drawable.angelo, "Angelo", "Male"));
        character.add(new CharacterModel(R.drawable.ian, "Ian", "Male"));
        character.add(new CharacterModel(R.drawable.katherine, "Katherine", "Female"));
        character.add(new CharacterModel(R.drawable.kenneth, "Kenneth", "Male"));
        character.add(new CharacterModel(R.drawable.hannah, "Hannah", "Female"));
        character.add(new CharacterModel(R.drawable.christine, "Christine", "Female"));
        character.add(new CharacterModel(R.drawable.aaron, "Aaron", "Male"));
        character.add(new CharacterModel(R.drawable.princess, "Princess", "Female"));
        character.add(new CharacterModel(R.drawable.clarence, "Clarence", "Male"));
        character.add(new CharacterModel(R.drawable.ivan, "Ivan", "Male"));
        character.add(new CharacterModel(R.drawable.gabrielle, "Gabrielle", "Female"));
        character.add(new CharacterModel(R.drawable.jerome, "Jerome", "Male"));
        character.add(new CharacterModel(R.drawable.mark, "Mark", "Male"));
        character.add(new CharacterModel(R.drawable.kate, "Kate", "Female"));
        character.add(new CharacterModel(R.drawable.tiffany, "Tiffany", "Female"));
        character.add(new CharacterModel(R.drawable.louie, "Louie", "Male"));
        character.add(new CharacterModel(R.drawable.clara, "Clara", "Female"));
        character.add(new CharacterModel(R.drawable.jovan, "Jovan", "Male"));
        character.add(new CharacterModel(R.drawable.roselyn, "Roselyn", "Female"));
        character.add(new CharacterModel(R.drawable.kevin, "Kevin", "Male"));
        character.add(new CharacterModel(R.drawable.dave, "Dave", "Male"));
    }
}
