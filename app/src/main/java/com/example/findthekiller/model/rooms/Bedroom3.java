package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;

import java.util.ArrayList;
import java.util.Random;

public class Bedroom3 extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public Bedroom3()
    {
        super("third bedroom", false);
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
        soloActivities.add("sleeping");
        soloActivities.add("having a deep sleep");
        soloActivities.add("taking a rest");
        soloActivities.add("having a nap");
        soloActivities.add("laying in bed chilling");
        soloActivities.add("scrolling in my phone");
        soloActivities.add("enjoying the fluffy bed");
    }

    private void duoActivity()
    {
        duoActivities.add("sleeping");
        duoActivities.add("talking in bed");
        duoActivities.add("having a deep sleep");
        duoActivities.add("taking a rest");
        duoActivities.add("having a nap");
        duoActivities.add("laying in bed chilling");
        duoActivities.add("scrolling in my phone");
        duoActivities.add("enjoying the fluffy bed");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("making out");
        duoPartnerActivities.add("flirting");
        duoPartnerActivities.add("cuddling");
        duoPartnerActivities.add("intimate kissing");
        duoPartnerActivities.add("teasing");
        duoPartnerActivities.add("masturbating");
        duoPartnerActivities.add("french kissing");
        duoPartnerActivities.add("complimenting");
        duoPartnerActivities.add("touching each other naked");
        duoPartnerActivities.add("having a longest rough sex");
    }

    private void groupActivity()
    {
        groupActivities.add("sleeping");
        groupActivities.add("talking in bed");
        groupActivities.add("having a deep sleep");
        groupActivities.add("taking a rest");
        groupActivities.add("having a nap");
        groupActivities.add("laying in bed chilling");
        groupActivities.add("scrolling in my phone");
        groupActivities.add("enjoying the fluffy bed");
        groupActivities.add("having a pillow fight");
    }
}
