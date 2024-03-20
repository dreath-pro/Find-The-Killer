package com.example.findthekiller.fragment;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.findthekiller.R;
import com.example.findthekiller.model.PlayerModel;

public class KilledFragment extends Fragment {
    TextView playerKilledText;
    TextView playerName, playerGender, playerRole;
    Button backButton;

    private PlayerModel selectedPlayer;
    private MediaPlayer deathSound;
    private AudioManager audioManager;
    private Context context;

    public KilledFragment(PlayerModel selectedPlayer)
    {
        this.selectedPlayer = selectedPlayer;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_killed, container, false);

        playerKilledText = view.findViewById(R.id.playerKilledText);
        playerName = view.findViewById(R.id.playerName);
        playerGender = view.findViewById(R.id.playerGender);
        playerRole = view.findViewById(R.id.playerRole);
        backButton = view.findViewById(R.id.backButton);

        playerKilledText.setText(apostrophePlacement());
        playerName.setText(selectedPlayer.getName());
        playerGender.setText(selectedPlayer.getGender());
        playerRole.setText(selectedPlayer.getRole());

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToGame();
            }
        });

        return view;
    }

    private String apostrophePlacement()
    {
        String playerName = selectedPlayer.getName();
        String lastLetter, apostrophePlacement;

        lastLetter = playerName.substring(playerName.length() - 1);

        if(lastLetter.equals("s"))
        {
            apostrophePlacement = "'";
        }else
        {
            apostrophePlacement = "'s";
        }

        return playerName + apostrophePlacement + " corpse has been found!";
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;

        deathSound = MediaPlayer.create(context, R.raw.tragedy);
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        deathSound.start();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if(deathSound != null)
        {
            deathSound.release();
        }
    }

    private void backToGame()
    {
        if(getActivity() != null)
        {
            getActivity().getSupportFragmentManager().popBackStack();
        }
    }
}