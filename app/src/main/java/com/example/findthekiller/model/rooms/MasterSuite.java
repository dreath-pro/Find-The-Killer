package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;

import java.util.ArrayList;
import java.util.Random;

public class MasterSuite extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public MasterSuite()
    {
        super("master suite room", false);
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
        soloActivities.add("taking a break");
        soloActivities.add("resting");
        soloActivities.add("laying in bed watching TV");
        soloActivities.add("laying in bed watching movies");
        soloActivities.add("scrolling in my phone");
    }

    private void duoActivity()
    {
        duoActivities.add("sleeping");
        duoActivities.add("talking");
        duoActivities.add("taking a break");
        duoActivities.add("resting");
        duoActivities.add("laying in bed watching TV");
        duoActivities.add("laying in bed watching movies");
        duoActivities.add("scrolling in my phone");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("making out");
        duoPartnerActivities.add("intimate kissing");
        duoPartnerActivities.add("having long sex");
        duoPartnerActivities.add("had sex");
        duoPartnerActivities.add("had slept");
        duoPartnerActivities.add("making babies");
    }

    private void groupActivity()
    {
        groupActivities.add("sleeping");
        groupActivities.add("talking");
        groupActivities.add("taking a break");
        groupActivities.add("resting");
        groupActivities.add("laying in bed watching TV");
        groupActivities.add("laying in bed watching movies");
        groupActivities.add("scrolling in my phone");
    }
}
