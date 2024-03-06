package com.example.findthekiller;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InterrogationAdapter extends RecyclerView.Adapter<InterrogationAdapter.MyViewHolder> {
    Context context;
    ArrayList<PlayerModel> playerModels;
    GameActivity gameActivity = new GameActivity();
    TextView chatBox;
    private ArrayList<SpannableStringBuilder> conversation = new ArrayList<>();

    public InterrogationAdapter(Context context, ArrayList<PlayerModel> playerModels, TextView chatBox, ArrayList<SpannableStringBuilder> conversation) {
        this.context = context;
        this.playerModels = playerModels;
        this.chatBox = chatBox;
        this.conversation = conversation;
    }

    @NonNull
    @Override
    public InterrogationAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.player_selection, parent, false);
        return new InterrogationAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InterrogationAdapter.MyViewHolder holder, int position) {
        holder.name.setText(playerModels.get(position).getName());
        holder.image.setImageResource(playerModels.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameActivity.setSelectedPlayer(playerModels.get(holder.getAdapterPosition()));
                gameActivity.setSelectedIndex(holder.getAdapterPosition());
                chatBox.setText(conversation.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return playerModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.playerImage);
            name = itemView.findViewById(R.id.playerName);
        }
    }
}
