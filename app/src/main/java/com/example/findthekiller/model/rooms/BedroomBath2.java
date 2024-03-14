package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;

import java.util.ArrayList;
import java.util.Random;

public class BedroomBath2 extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public BedroomBath2()
    {
        super("second bedroom bath", false);
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
        soloActivities.add("bathing");
        soloActivities.add("half bathing");
        soloActivities.add("relaxing in the tub");
        soloActivities.add("showering");
        soloActivities.add("chilling in the tub");
        soloActivities.add("having some warm bath");
    }

    private void duoActivity()
    {
        duoActivities.add("waiting");
        duoActivities.add("waiting while talking");
        duoActivities.add("brushing my teeth while waiting");
        duoActivities.add("combing my hair while waiting");
        duoActivities.add("fixing my face");
        duoActivities.add("maintaining my hygiene");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("bathing");
        duoPartnerActivities.add("half bathing");
        duoPartnerActivities.add("relaxing in the tub");
        duoPartnerActivities.add("showering");
        duoPartnerActivities.add("having a rough sex");
        duoPartnerActivities.add("having a slow and intimate sex");
        duoPartnerActivities.add("chilling in the tub");
        duoPartnerActivities.add("having some warm bath");
        duoPartnerActivities.add("making out while bathing");
    }

    private void groupActivity()
    {
        groupActivities.add("waiting");
        groupActivities.add("waiting while talking");
        groupActivities.add("brushing my teeth while waiting");
        groupActivities.add("combing my hair while waiting");
        groupActivities.add("fixing my face");
        groupActivities.add("having a group fuck");
        groupActivities.add("doing gangbang");
        groupActivities.add("maintaining my hygiene");
    }
}
