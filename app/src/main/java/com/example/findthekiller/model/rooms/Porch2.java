package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;

import java.util.ArrayList;
import java.util.Random;

public class Porch2 extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public Porch2()
    {
        super("second porch", false);
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
        soloActivities.add("watching the nature");
        soloActivities.add("looking for some fresh air");
        soloActivities.add("eating some snack");
        soloActivities.add("chilling");
        soloActivities.add("taking a nap");
        soloActivities.add("sleeping");
        soloActivities.add("playing guitar");
    }

    private void duoActivity()
    {
        duoActivities.add("talking");
        duoActivities.add("looking for some fresh air");
        duoActivities.add("watching the nature");
        duoActivities.add("sitting in sofa");
        duoActivities.add("having a deep conversation");
        duoActivities.add("sitting in chair");
        duoActivities.add("messing");
        duoActivities.add("drinking wine");
        duoActivities.add("playing card");
        duoActivities.add("playing guitar");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("making out");
        duoPartnerActivities.add("flirting");
        duoPartnerActivities.add("cuddling");
        duoPartnerActivities.add("intimate kissing");
        duoPartnerActivities.add("teasing");
        duoPartnerActivities.add("serenading with my guitar");
        duoPartnerActivities.add("complimenting");
        duoPartnerActivities.add("showing flowers");
    }

    private void groupActivity()
    {
        groupActivities.add("playing guitar");
        groupActivities.add("having a deep conversation");
        groupActivities.add("sitting in chair");
        groupActivities.add("sitting in sofa");
        groupActivities.add("staying");
        groupActivities.add("drinking wine");
        groupActivities.add("playing card");
        groupActivities.add("group singing");
    }
}
