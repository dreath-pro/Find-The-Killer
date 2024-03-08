package com.example.findthekiller;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InterrogationAdapter extends RecyclerView.Adapter<InterrogationAdapter.MyViewHolder> {
    Context context;
    ArrayList<PlayerModel> playerModels;
    GameActivity gameActivity;
    TextView chatBox;
    private ArrayList<SpannableStringBuilder> conversation = new ArrayList<>();

    public InterrogationAdapter(Context context, ArrayList<PlayerModel> playerModels, TextView chatBox, ArrayList<SpannableStringBuilder> conversation, GameActivity gameActivity) {
        this.context = context;
        this.playerModels = playerModels;
        this.chatBox = chatBox;
        this.conversation = conversation;
        this.gameActivity = gameActivity;
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

        if(playerModels.get(position).isEliminated()) {
            setDesaturatedColor(holder.image);
            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.   color.eliminatedColor));
        } else {
            holder.image.setColorFilter(null);
            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.defaultColor));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!playerModels.get(holder.getAdapterPosition()).isEliminated())
                {
                    gameActivity.setSelectedPlayer(playerModels.get(holder.getAdapterPosition()));
                    gameActivity.setSelectedIndex(holder.getAdapterPosition());
                    chatBox.setText(conversation.get(holder.getAdapterPosition()));
                }
            }
        });
    }

    private void setDesaturatedColor(ImageView imageView)
    {
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        imageView.setColorFilter(filter);
    }

    @Override
    public int getItemCount() {
        return playerModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.playerImage);
            name = itemView.findViewById(R.id.playerName);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
