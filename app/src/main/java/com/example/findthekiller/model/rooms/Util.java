package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;

import java.util.ArrayList;
import java.util.Random;

public class Util extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public Util()
    {
        super("utility room", false);
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
        soloActivities.add("cleaning the clothes");
        soloActivities.add("doing some laundry");
        soloActivities.add("drying the clothes");
        soloActivities.add("cleaning the room");
        soloActivities.add("cleaning the washers");
        soloActivities.add("hanging the clothes");
    }

    private void duoActivity()
    {
        duoActivities.add("helping cleaning the clothes");
        duoActivities.add("doing some laundry");
        duoActivities.add("drying the clothes");
        duoActivities.add("helping cleaning the room");
        duoActivities.add("cleaning the washers");
        duoActivities.add("hanging the clothes");
        duoActivities.add("talking while doing laundry");
        duoActivities.add("talking while cleaning the room");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("making out");
        duoPartnerActivities.add("cuddling");
        duoPartnerActivities.add("intimate kissing");
        duoPartnerActivities.add("having romantic sex");
        duoPartnerActivities.add("enjoying our sweet and lovely time");
        duoPartnerActivities.add("intimate playing");
    }

    private void groupActivity()
    {
        groupActivities.add("helping cleaning the clothes");
        groupActivities.add("doing some laundry");
        groupActivities.add("drying the clothes");
        groupActivities.add("helping cleaning the room");
        groupActivities.add("cleaning the washers");
        groupActivities.add("hanging the clothes");
        groupActivities.add("talking while doing laundry");
        groupActivities.add("talking while cleaning the room");
    }
}
