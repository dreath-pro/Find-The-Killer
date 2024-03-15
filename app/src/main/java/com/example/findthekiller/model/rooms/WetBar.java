package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;

import java.util.ArrayList;
import java.util.Random;

public class WetBar extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public WetBar()
    {
        super("wet bar", false);
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
        soloActivities.add("drinking some wine");
        soloActivities.add("having some drinks");
        soloActivities.add("chilling");
        soloActivities.add("killing some time");
        soloActivities.add("scrolling in my phone");
    }

    private void duoActivity()
    {
        duoActivities.add("drinking some wine");
        duoActivities.add("having some drinks");
        duoActivities.add("chilling");
        duoActivities.add("happily talking");
        duoActivities.add("meeting");
        duoActivities.add("having some good time");
        duoActivities.add("scrolling in my phone");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("making out");
        duoPartnerActivities.add("flirting");
        duoPartnerActivities.add("hitting");
        duoPartnerActivities.add("intimate kissing");
        duoPartnerActivities.add("complimenting");
        duoPartnerActivities.add("fucking without condom");
        duoPartnerActivities.add("fucking with condom");
        duoPartnerActivities.add("sweet talking and kissing");
        duoPartnerActivities.add("dancing seductively");
        duoPartnerActivities.add("seductively touching each other");
    }

    private void groupActivity()
    {
        groupActivities.add("drinking some wine");
        groupActivities.add("having some drinks");
        groupActivities.add("chilling");
        groupActivities.add("happily talking");
        groupActivities.add("meeting");
        groupActivities.add("dancing seductively");
        groupActivities.add("having some good time");
        groupActivities.add("scrolling in my phone");
    }
}
