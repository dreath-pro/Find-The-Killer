package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;

import java.util.ArrayList;
import java.util.Random;

public class Mud extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public Mud()
    {
        super("mud room", false);
        soloActivity();
        duoActivity();
        duoPartnerActivity();
        groupActivity();
    }

    @Override
    public String getActivity(int groupType)
    {
        Random random = new Random();
        int selectedActivity;

        switch (groupType)
        {
            case 0:
                selectedActivity = random.nextInt(soloActivities.size());
                roomActivities = soloActivities.get(selectedActivity);
                break;
            case 1:
                selectedActivity = random.nextInt(duoActivities.size());
                roomActivities = duoActivities.get(selectedActivity);
                break;
            case 2:
                selectedActivity = random.nextInt(duoPartnerActivities.size());
                roomActivities = duoPartnerActivities.get(selectedActivity);
                break;
            case 3:
                selectedActivity = random.nextInt(groupActivities.size());
                roomActivities = groupActivities.get(selectedActivity);
                break;
        }
        return roomActivities;
    }

    private void soloActivity()
    {
        soloActivities.add("on the way to put my slippers");
        soloActivities.add("on the way to put my shoes");
        soloActivities.add("putting my raincoat");
        soloActivities.add("putting my coat");
        soloActivities.add("drying my coat");
        soloActivities.add("drying my raincoat");
    }

    private void duoActivity()
    {
        duoActivities.add("on the way to put my slippers");
        duoActivities.add("on the way to put my shoes");
        duoActivities.add("putting my raincoat");
        duoActivities.add("putting my coat");
        duoActivities.add("drying my coat");
        duoActivities.add("drying my raincoat");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("flirting");
        duoPartnerActivities.add("teasing");
        duoPartnerActivities.add("complimenting");
        duoPartnerActivities.add("putting the coat while holding hands");
        duoPartnerActivities.add("putting the raincoat while holding hands");
        duoPartnerActivities.add("putting the shoes while holding hands");
        duoPartnerActivities.add("putting the slippers while holding hands");
    }

    private void groupActivity()
    {
        groupActivities.add("on the way to put my slippers");
        groupActivities.add("on the way to put my shoes");
        groupActivities.add("putting my raincoat");
        groupActivities.add("putting my coat");
        groupActivities.add("drying my coat");
        groupActivities.add("drying my raincoat");
    }
}
