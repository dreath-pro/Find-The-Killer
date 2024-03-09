package com.example.findthekiller.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.findthekiller.model.PlayerModel;
import com.example.findthekiller.R;
import com.example.findthekiller.adapter.KillerAdapter;

import java.util.ArrayList;

public class AftergameFragment extends Fragment {
    Button menuButton;
    TextView aftergamePrompt, killerText;
    RecyclerView killerView;
    RelativeLayout aftergameLayout;

    private ArrayList<PlayerModel> killerLists;
    private Context context;
    private boolean isWinning;
    private int failPrompt, failText, failBackground;

    public AftergameFragment(ArrayList<PlayerModel> killerLists, boolean isWinning)
    {
        this.killerLists = killerLists;
        this.isWinning = isWinning;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aftergame, container, false);

        menuButton = view.findViewById(R.id.menuButton);
        aftergamePrompt = view.findViewById(R.id.aftergamePrompt);
        killerText = view.findViewById(R.id.killerText);
        killerView = view.findViewById(R.id.killerView);
        aftergameLayout = view.findViewById(R.id.aftergameLayout);

        KillerAdapter killerAdapter = new KillerAdapter(context, killerLists);
        killerView.setAdapter(killerAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        killerView.setLayoutManager(layoutManager);

        setGameResult();

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getActivity() != null)
                {
                    getActivity().getSupportFragmentManager().popBackStack();
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;

        failPrompt = ContextCompat.getColor(context, R.color.failPrompt);
        failText = ContextCompat.getColor(context, R.color.failText);
        failBackground = ContextCompat.getColor(context, R.color.failBackground);
    }

    private void setFailColor()
    {
        aftergamePrompt.setTextColor(failPrompt);
        killerText.setTextColor(failText);
        aftergameLayout.setBackgroundColor(failBackground);
    }

    @SuppressLint("SetTextI18n")
    private void setGameResult()
    {
        if(isWinning)
        {
            if(killerLists.size() > 1)
            {
                aftergamePrompt.setText("You found all killers!");
            }else
            {
                aftergamePrompt.setText("You found the killer!");
            }
        }else
        {
            aftergamePrompt.setText("You failed!");

            setFailColor();
        }

        if(killerLists.size() > 1)
        {
            killerText.setText("The " + killerLists.size() + " killers are ");
            for(int i = 0; i <= killerLists.size() - 1; i++)
            {
                String toAppend = "";
                if(i < (killerLists.size() - 1))
                {
                    toAppend = ", ";
                }
                if((i + 1) == (killerLists.size() - 1))
                {
                    toAppend = " and ";
                }
                if(i == (killerLists.size() - 1))
                {
                    toAppend = ".";
                }
                killerText.append(killerLists.get(i).getName() + toAppend);
            }
        }else
        {
            killerText.setText("The killers is " + killerLists.get(0).getName());
        }
    }
}