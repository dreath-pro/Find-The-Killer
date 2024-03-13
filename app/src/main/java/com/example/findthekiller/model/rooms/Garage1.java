package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;

import java.util.ArrayList;
import java.util.Random;

public class Garage1 extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public Garage1()
    {
        super("first garage", false);
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
        soloActivities.add("cleaning the tools");
        soloActivities.add("cleaning the car");
        soloActivities.add("maintaining the car");
        soloActivities.add("checking the tools");
        soloActivities.add("finding some missing tools");
        soloActivities.add("wiping the car window");
        soloActivities.add("cleaning the floor");
        soloActivities.add("testing the car engine");
        soloActivities.add("parking the car");
    }

    private void duoActivity()
    {
        duoActivities.add("helping with cleaning the tools");
        duoActivities.add("showing the car");
        duoActivities.add("helping with cleaning the cars");
        duoActivities.add("maintaining the car");
        duoActivities.add("counting the tools");
        duoActivities.add("helping finding the missing tools");
        duoActivities.add("talking inside the car");
        duoActivities.add("parking the car");
        duoActivities.add("planning some road-trip");
        duoActivities.add("happily chatting inside the car");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("making out inside the car");
        duoPartnerActivities.add("intimate time");
        duoPartnerActivities.add("cuddling in the car");
        duoPartnerActivities.add("having sex in the car");
        duoPartnerActivities.add("doing blowjob in the car");
        duoPartnerActivities.add("complimenting");
        duoPartnerActivities.add("touching each other sexually");
    }

    private void groupActivity()
    {
        groupActivities.add("helping with cleaning the tools");
        groupActivities.add("showing the car");
        groupActivities.add("helping with cleaning the cars");
        groupActivities.add("maintaining the car");
        groupActivities.add("counting the tools");
        groupActivities.add("helping finding the missing tools");
        groupActivities.add("having deep conversation");
        groupActivities.add("parking the car");
        groupActivities.add("planning some road-trip");
        groupActivities.add("happily chatting inside the car");
    }
}
