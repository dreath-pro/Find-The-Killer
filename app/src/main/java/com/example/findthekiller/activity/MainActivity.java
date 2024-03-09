package com.example.findthekiller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.findthekiller.R;

public class MainActivity extends AppCompatActivity {
    //female wearing spring outfit, cute webtoon aesthetic, simple color, matured face, white plain background
    //killer icon - https://www.flaticon.com/free-icon/serial-killer_1233003?term=killer&page=1&position=6&origin=search&related_id=1233003
    //survivor icon - https://www.flaticon.com/free-icon/multiple-users-silhouette_33308?term=person&page=1&position=88&origin=search&related_id=33308
    Button startButton, guideButton, optionButton, quitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        guideButton = findViewById(R.id.guideButton);
        optionButton = findViewById(R.id.optionButton);
        quitButton = findViewById(R.id.quitButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lineup();
            }
        });

        guideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Haha Jimhardcore", Toast.LENGTH_SHORT).show();
            }
        });

        optionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Haha Jimhardcore", Toast.LENGTH_SHORT).show();
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void lineup()
    {
        Intent intent = new Intent(getApplicationContext(), LineupActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}