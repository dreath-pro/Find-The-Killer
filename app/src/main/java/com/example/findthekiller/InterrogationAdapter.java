package com.example.findthekiller;

import android.content.Context;
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

    public InterrogationAdapter(Context context, ArrayList<PlayerModel> playerModels) {
        this.context = context;
        this.playerModels = playerModels;
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
        holder.image.setImageResource(playerModels.get(position).getCloseupView());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Haha " + playerModels.get(holder.getAdapterPosition()).getName() + " selected", Toast.LENGTH_SHORT).show();
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
