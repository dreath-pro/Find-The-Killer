package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;
import com.example.findthekiller.model.PlayerModel;

import java.util.ArrayList;
import java.util.Random;

public class Porch1 extends HouseModel {
    private ArrayList<String> roomActivities = new ArrayList<>();

    public Porch1()
    {
        super("First Porch", false);
        initializeActivity();
    }

    @Override
    public String getActivity()
    {
        Random random = new Random();
        int selectedActivity = random.nextInt(roomActivities.size());
        return roomActivities.get(selectedActivity);
    }

    private void initializeActivity()
    {
        roomActivities.add("watching the nature");
        roomActivities.add("hanging for some fresh air");
        roomActivities.add("talking");
        roomActivities.add("drinking wine");
        roomActivities.add("eating some snack");
        roomActivities.add("chilling");
        roomActivities.add("taking a nap");
        roomActivities.add("sleeping");
        roomActivities.add("having a chit chat");
        roomActivities.add("playing card");
        roomActivities.add("playing guitar");
    }
}
