package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;

import java.util.ArrayList;
import java.util.Random;

public class Foyer extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public Foyer()
    {
        super("foyer room", false);
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
        soloActivities.add("sitting in the chair");
        soloActivities.add("sitting in sofa");
        soloActivities.add("playing piano");
        soloActivities.add("watching the beautiful painting");
        soloActivities.add("watching the beautiful sculptures");
        soloActivities.add("watching the mirror");
        soloActivities.add("waiting for someone");
        soloActivities.add("taking a catnap");
        soloActivities.add("watching the beautiful view outside");
    }

    private void duoActivity()
    {
        duoActivities.add("sitting in the chair");
        duoActivities.add("sitting in sofa");
        duoActivities.add("playing piano");
        duoActivities.add("watching the beautiful painting");
        duoActivities.add("watching the beautiful sculptures");
        duoActivities.add("waiting for someone");
        duoActivities.add("taking a catnap");
        duoActivities.add("watching the beautiful view outside");
        duoActivities.add("talking");
        duoActivities.add("having a deep conversation");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("making out");
        duoPartnerActivities.add("flirting");
        duoPartnerActivities.add("cuddling");
        duoPartnerActivities.add("intimate kissing");
        duoPartnerActivities.add("having sweet talk");
        duoPartnerActivities.add("teasing");
        duoPartnerActivities.add("complimenting");
    }

    private void groupActivity()
    {
        groupActivities.add("sitting in the chair");
        groupActivities.add("sitting in sofa");
        groupActivities.add("playing piano");
        groupActivities.add("watching the beautiful painting");
        groupActivities.add("watching the beautiful sculptures");
        groupActivities.add("waiting for someone");
        groupActivities.add("taking a catnap");
        groupActivities.add("watching the beautiful view outside");
        groupActivities.add("talking");
        groupActivities.add("having a deep conversation");
    }
}
