package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;

import java.util.ArrayList;
import java.util.Random;

public class Garden extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public Garden()
    {
        super("garden", false);
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
        soloActivities.add("watering the plants");
        soloActivities.add("taking care of the flowers and plants");
        soloActivities.add("putting some ornaments");
        soloActivities.add("planting new seed");
        soloActivities.add("sitting and viewing the flowers");
        soloActivities.add("scrolling through my phone");
        soloActivities.add("fell asleep");
        soloActivities.add("playing with golden retriever");
        soloActivities.add("watching the butterflies");
        soloActivities.add("playing guitar and singing");
    }

    private void duoActivity()
    {
        duoActivities.add("watering the plants");
        duoActivities.add("taking care of the flowers and plants");
        duoActivities.add("putting some ornaments");
        duoActivities.add("planting new seed");
        duoActivities.add("sitting and viewing the flowers");
        duoActivities.add("scrolling through my phone");
        duoActivities.add("fell asleep");
        duoActivities.add("playing with golden retriever");
        duoActivities.add("watching the butterflies");
        duoActivities.add("talking");
        duoActivities.add("playing guitar and singing");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("making out");
        duoPartnerActivities.add("flirting");
        duoPartnerActivities.add("cuddling");
        duoPartnerActivities.add("french kissing");
        duoPartnerActivities.add("touching body");
        duoPartnerActivities.add("serenading with my guitar");
        duoPartnerActivities.add("complimenting");
        duoPartnerActivities.add("giving rose");
        duoPartnerActivities.add("giving secret and quick blowjob");
    }

    private void groupActivity()
    {
        groupActivities.add("watering the plants");
        groupActivities.add("taking care of the flowers and plants");
        groupActivities.add("putting some ornaments");
        groupActivities.add("planting new seed");
        groupActivities.add("sitting and viewing the flowers");
        groupActivities.add("scrolling through my phone");
        groupActivities.add("fell asleep");
        groupActivities.add("playing with golden retriever");
        groupActivities.add("watching the butterflies");
        groupActivities.add("talking");
        groupActivities.add("playing guitar and singing");
    }
}
