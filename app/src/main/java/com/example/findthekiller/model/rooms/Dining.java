package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;

import java.util.ArrayList;
import java.util.Random;

public class Dining extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public Dining()
    {
        super("dining room", false);
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
        soloActivities.add("eating");
        soloActivities.add("eating breakfast");
        soloActivities.add("eating lunch");
        soloActivities.add("eating dinner");
        soloActivities.add("eating my favorite dish");
    }

    private void duoActivity()
    {
        duoActivities.add("eating");
        duoActivities.add("eating breakfast");
        duoActivities.add("eating lunch");
        duoActivities.add("eating dinner");
        duoActivities.add("eating my favorite dish");
        duoActivities.add("eating while talking");
        duoActivities.add("eating breakfast while talking");
        duoActivities.add("eating lunch while talking");
        duoActivities.add("eating dinner while talking");
        duoActivities.add("eating my favorite dish while talking");
        duoActivities.add("making fun while eating");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("flirting while eating");
        duoPartnerActivities.add("teasing while eating");
        duoPartnerActivities.add("complimenting while eating");
        duoPartnerActivities.add("making sweet talk while eating");
    }

    private void groupActivity()
    {
        groupActivities.add("eating");
        groupActivities.add("eating breakfast");
        groupActivities.add("eating lunch");
        groupActivities.add("eating dinner");
        groupActivities.add("eating my favorite dish");
        groupActivities.add("eating while talking");
        groupActivities.add("eating breakfast while talking");
        groupActivities.add("eating lunch while talking");
        groupActivities.add("eating dinner while talking");
        groupActivities.add("eating my favorite dish while talking");
        groupActivities.add("making fun while eating");
    }
}
