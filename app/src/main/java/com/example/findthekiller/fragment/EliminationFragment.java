package com.example.findthekiller.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.findthekiller.model.PlayerModel;
import com.example.findthekiller.R;
import com.example.findthekiller.activity.GameActivity;

public class EliminationFragment extends Fragment {
    LinearLayout indicators, details;
    ImageView playerImage;
    TextView resultPrompt;
    TextView playerName, playerGender, playerRole;
    Button backButton;
    private PlayerModel selectedPlayer;

    private Handler handler = new Handler();
    int survivorColor, killerColor;
    GameActivity gameActivity = new GameActivity();
    Context context;

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

        delayResult();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToGame();
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;

        survivorColor = ContextCompat.getColor(context, R.color.survivorColor);
        killerColor = ContextCompat.getColor(context, R.color.killerColor);
    }

    private void delayResult()
    {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String genderRefer;
                if(selectedPlayer.getGender().equals("Male"))
                {
                    genderRefer = "he's";
                }else
                {
                    genderRefer = "she's";
                }

                if(selectedPlayer.getRole().equals("Killer"))
                {
                    resultPrompt.setText(selectedPlayer.getName() + " is found guilty; " + genderRefer + " the culprit and the killer.");
                    resultPrompt.setTextColor(killerColor);
                }else
                {
                    resultPrompt.setText(selectedPlayer.getName() + " is innocent.");
                    resultPrompt.setTextColor(survivorColor);
                }

                backButton.setEnabled(true);
                indicators.setVisibility(View.VISIBLE);
                details.setVisibility(View.VISIBLE);
            }
        }, 900);
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

        backButton.setEnabled(false);
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