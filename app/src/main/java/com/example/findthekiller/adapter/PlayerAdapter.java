package com.example.findthekiller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findthekiller.model.PlayerModel;
import com.example.findthekiller.R;

import java.util.ArrayList;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.MyViewHolder> {
    Context context;
    ArrayList<PlayerModel> playerModels;

    public PlayerAdapter(Context context, ArrayList<PlayerModel> playerModels)
    {
        this.context = context;
        this.playerModels = playerModels;
    }

    @NonNull
    @Override
    public PlayerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view, parent, false);
        return new PlayerAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerAdapter.MyViewHolder holder, int position) {
        holder.name.setText(playerModels.get(position).getName());
        holder.imageView.setImageResource(playerModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return playerModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView name;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            imageView = itemView.findViewById(R.id.playerImage);
            name = itemView.findViewById(R.id.playerName);
        }
    }
}
