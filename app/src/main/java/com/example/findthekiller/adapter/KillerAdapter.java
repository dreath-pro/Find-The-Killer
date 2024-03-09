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

public class KillerAdapter extends RecyclerView.Adapter<KillerAdapter.MyViewHolder> {
    ArrayList<PlayerModel> killerLists;
    Context context;

    public KillerAdapter(Context context, ArrayList<PlayerModel> killerLists)
    {
        this.context = context;
        this.killerLists = killerLists;
    }

    @NonNull
    @Override
    public KillerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.killer_view, parent, false);
        return new KillerAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KillerAdapter.MyViewHolder holder, int position) {
        holder.name.setText(killerLists.get(position).getName());
        holder.image.setImageResource(killerLists.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return killerLists.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView image;
        TextView name;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            image = itemView.findViewById(R.id.playerImage);
            name = itemView.findViewById(R.id.playerName);
        }
    }
}
