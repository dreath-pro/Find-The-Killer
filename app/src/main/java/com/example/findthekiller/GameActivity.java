package com.example.findthekiller;

import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AlignmentSpan;
import android.widget.TextView;

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

    SpannableStringBuilder builder = new SpannableStringBuilder();
    ArrayList<PlayerModel> playerModels = new ArrayList<>();
    RecyclerView playerInterrogation;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);

        playerInterrogation = findViewById(R.id.playerInterrogation);
        chatBox = findViewById(R.id.chatBox);

        builderMessages();
        chatBox.setText(builder);

        playerModels = getIntent().getParcelableArrayListExtra("playerModels");

        InterrogationAdapter interrogationAdapter = new InterrogationAdapter(this, playerModels);
        playerInterrogation.setAdapter(interrogationAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        playerInterrogation.setLayoutManager(layoutManager);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.gameLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
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
