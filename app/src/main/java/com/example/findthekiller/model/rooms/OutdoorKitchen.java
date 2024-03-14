package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;

import java.util.ArrayList;
import java.util.Random;

public class OutdoorKitchen extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public OutdoorKitchen()
    {
        super("outdoor kitchen", false);
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
        soloActivities.add("eating some fruits");
        soloActivities.add("eating some snacks");
        soloActivities.add("drinking juice");
        soloActivities.add("eating some fruits while looking for fresh air");
        soloActivities.add("eating some snacks while looking for fresh air");
        soloActivities.add("drinking juice while looking for fresh air");
        soloActivities.add("eating some fruits while watching TV");
        soloActivities.add("eating some snacks while watching TV");
        soloActivities.add("drinking juice while watching TV");
        soloActivities.add("watching movies while eating some snacks");
        soloActivities.add("watching TV");
        soloActivities.add("watching movies");
        soloActivities.add("cleaning the room");
        soloActivities.add("preparing some foods and drinks");
        soloActivities.add("cooking some foods");
        soloActivities.add("relaxing in the sofa");
    }

    private void duoActivity()
    {
        duoActivities.add("eating some fruits");
        duoActivities.add("talking");
        duoActivities.add("having a small talks and laughs");
        duoActivities.add("having deep conversation");
        duoActivities.add("eating some snacks");
        duoActivities.add("drinking juice");
        duoActivities.add("eating some fruits while looking for fresh air");
        duoActivities.add("eating some snacks while looking for fresh air");
        duoActivities.add("drinking juice while looking for fresh air");
        duoActivities.add("eating some fruits while watching TV");
        duoActivities.add("eating some snacks while watching TV");
        duoActivities.add("drinking juice while watching TV");
        duoActivities.add("watching movies while eating some snacks");
        duoActivities.add("watching TV");
        duoActivities.add("watching movies");
        duoActivities.add("cleaning the room");
        duoActivities.add("preparing some foods and drinks");
        duoActivities.add("cooking some foods");
        duoActivities.add("relaxing in the sofa");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("making out");
        duoPartnerActivities.add("flirting");
        duoPartnerActivities.add("cuddling");
        duoPartnerActivities.add("intimate kissing");
        duoPartnerActivities.add("teasing");
        duoPartnerActivities.add("complimenting");
        duoPartnerActivities.add("leaning on each other while watching TV");
    }

    private void groupActivity()
    {
        groupActivities.add("eating some fruits");
        groupActivities.add("talking");
        groupActivities.add("having a small talks and laughs");
        groupActivities.add("having deep conversation");
        groupActivities.add("eating some snacks");
        groupActivities.add("drinking juice");
        groupActivities.add("eating some fruits while looking for fresh air");
        groupActivities.add("eating some snacks while looking for fresh air");
        groupActivities.add("drinking juice while looking for fresh air");
        groupActivities.add("eating some fruits while watching TV");
        groupActivities.add("eating some snacks while watching TV");
        groupActivities.add("drinking juice while watching TV");
        groupActivities.add("watching movies while eating some snacks");
        groupActivities.add("watching TV");
        groupActivities.add("watching movies");
        groupActivities.add("cleaning the room");
        groupActivities.add("preparing some foods and drinks");
        groupActivities.add("cooking some foods");
        groupActivities.add("relaxing in the sofa");
    }
}
