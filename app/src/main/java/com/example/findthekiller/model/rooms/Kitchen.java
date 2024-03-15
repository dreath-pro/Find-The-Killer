package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;

import java.util.ArrayList;
import java.util.Random;

public class Kitchen extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public Kitchen()
    {
        super("kitchen", false);
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
        soloActivities.add("eating my favorite dish");
        soloActivities.add("eating some foods");
        soloActivities.add("craving some foods and fruits");
        soloActivities.add("cleaning the kitchen");
        soloActivities.add("washing some plates and utensils");
        soloActivities.add("preparing food");
        soloActivities.add("experimenting some dish");
    }

    private void duoActivity()
    {
        duoActivities.add("eating my favorite dish");
        duoActivities.add("eating some foods");
        duoActivities.add("craving some foods and fruits");
        duoActivities.add("cleaning the kitchen");
        duoActivities.add("washing some plates and utensils");
        duoActivities.add("preparing food");
        duoActivities.add("experimenting some dish");
        duoActivities.add("talking while eating");
        duoActivities.add("teasing while eating");
        duoActivities.add("making fun while eating");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("kissing cheeks");
        duoPartnerActivities.add("flirting");
        duoPartnerActivities.add("sweet whispering");
        duoPartnerActivities.add("teasing");
        duoPartnerActivities.add("complimenting");
        duoPartnerActivities.add("nudging and kissing");
    }

    private void groupActivity()
    {
        groupActivities.add("eating my favorite dish");
        groupActivities.add("eating some foods");
        groupActivities.add("craving some foods and fruits");
        groupActivities.add("cleaning the kitchen");
        groupActivities.add("washing some plates and utensils");
        groupActivities.add("preparing food");
        groupActivities.add("experimenting some dish");
        groupActivities.add("talking while eating");
        groupActivities.add("teasing while eating");
        groupActivities.add("making fun while eating");
    }
}
