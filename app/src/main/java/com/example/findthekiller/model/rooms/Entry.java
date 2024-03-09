package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;
import com.example.findthekiller.model.PlayerModel;

import java.util.ArrayList;
import java.util.Random;

public class Entry extends HouseModel {
    private ArrayList<String> roomActivities = new ArrayList<>();
    private ArrayList<PlayerModel> roomOccupants = new ArrayList<>();

    public Entry()
    {
        super("Entry", false);
        initializeActivity();
    }

    @Override
    public String getActivity()
    {
        Random random = new Random();
        int selectedActivity = random.nextInt(roomActivities.size());
        return roomActivities.get(selectedActivity);
    }

    private void addOccupant(PlayerModel occupant)
    {
        roomOccupants.add(occupant);
    }

    private void removeOccupant(PlayerModel occupant)
    {
        ArrayList<String> occupantNames = new ArrayList<>();

        for(PlayerModel roomOccupant : roomOccupants)
        {
            occupantNames.add(roomOccupant.getName());
        }
        int occupantIndex = occupantNames.indexOf(occupant.getName());

        roomOccupants.remove(occupantIndex);
    }

    private void initializeActivity()
    {
        roomActivities.add("sitting in sofa");
        roomActivities.add("sitting in chair");
        roomActivities.add("viewing the mirror");
        roomActivities.add("watching the beautiful decorations");
        roomActivities.add("waiting at someone");
    }
}
