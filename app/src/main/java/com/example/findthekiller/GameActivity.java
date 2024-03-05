package com.example.findthekiller;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AlignmentSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity extends AppCompatActivity {
    TextView chatBox;

    SpannableStringBuilder builder = new SpannableStringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);

        chatBox = findViewById(R.id.chatBox);

        builderMessages();
        chatBox.setText(builder);

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
