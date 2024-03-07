package com.example.findthekiller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EliminationFragment extends Fragment {
    LinearLayout indicators, details;
    ImageView playerImage;
    TextView resultPrompt;
    TextView playerName, playerGender, playerRole;
    Button backButton;
    PlayerModel selectedPlayer;

    public EliminationFragment(PlayerModel selectedPlayer)
    {
        this.selectedPlayer = selectedPlayer;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_elimination, container, false);
        initializeComponent(view);
        initializeData();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToGame();
            }
        });

        return view;
    }

    private void initializeComponent(View view)
    {
        playerImage = view.findViewById(R.id.playerImage);
        resultPrompt = view.findViewById(R.id.resultPrompt);
        playerName = view.findViewById(R.id.playerName);
        playerGender = view.findViewById(R.id.playerGender);
        playerRole = view.findViewById(R.id.playerRole);
        backButton = view.findViewById(R.id.backButton);
        indicators = view.findViewById(R.id.indicators);
        details = view.findViewById(R.id.details);
    }

    private void initializeData()
    {
        playerImage.setImageResource(selectedPlayer.getImage());
        resultPrompt.setText(selectedPlayer.getName() + " is Eliminated!");
        playerName.setText(selectedPlayer.getName());
        playerGender.setText(selectedPlayer.getGender());
        playerRole.setText(selectedPlayer.getRole());

        backButton.setVisibility(View.INVISIBLE);
        indicators.setVisibility(View.INVISIBLE);
        details.setVisibility(View.INVISIBLE);
    }

    private void backToGame()
    {
        if(getActivity() != null)
        {
            getActivity().getSupportFragmentManager().popBackStack();
        }
    }
}