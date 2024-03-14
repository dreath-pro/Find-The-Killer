package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;

import java.util.ArrayList;
import java.util.Random;

public class BathWardrobe2 extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public BathWardrobe2()
    {
        super("second bath wardrobe", false);
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
        soloActivities.add("changing clothe");
        soloActivities.add("folding some clothes");
        soloActivities.add("ironing clothes");
        soloActivities.add("hanging some clothes");
        soloActivities.add("arranging clothes");
        soloActivities.add("cleaning the room");
    }

    private void duoActivity()
    {
        duoActivities.add("changing clothe");
        duoActivities.add("folding some clothes");
        duoActivities.add("ironing clothes");
        duoActivities.add("hanging some clothes");
        duoActivities.add("arranging clothes");
        duoActivities.add("cleaning the room");
        duoActivities.add("having deep conversation while folding clothes");
        duoActivities.add("teasing while folding clothes");
        duoActivities.add("laughing and talking while folding clothes");
        duoActivities.add("having deep conversation while ironing clothes");
        duoActivities.add("teasing while ironing clothes");
        duoActivities.add("laughing and talking while ironing clothes");
        duoActivities.add("having deep conversation while hanging some clothes");
        duoActivities.add("teasing while hanging some clothes");
        duoActivities.add("laughing and talking while hanging some clothes");
        duoActivities.add("having deep conversation while arranging clothes");
        duoActivities.add("teasing while arranging clothes");
        duoActivities.add("laughing and talking while arranging clothes");
        duoActivities.add("having deep conversation while cleaning the room");
        duoActivities.add("teasing while cleaning the room");
        duoActivities.add("laughing and talking cleaning the room");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("making out");
        duoPartnerActivities.add("flirting");
        duoPartnerActivities.add("cuddling");
        duoPartnerActivities.add("intimate kissing");
        duoPartnerActivities.add("teasing");
        duoPartnerActivities.add("having a quickie sex");
        duoPartnerActivities.add("having a secret sex");
        duoPartnerActivities.add("complimenting");
        duoPartnerActivities.add("sensually touching body");
        duoPartnerActivities.add("performing BDSM sex");
    }

    private void groupActivity()
    {
        groupActivities.add("changing clothe");
        groupActivities.add("folding some clothes");
        groupActivities.add("ironing clothes");
        groupActivities.add("hanging some clothes");
        groupActivities.add("arranging clothes");
        groupActivities.add("cleaning the room");
        groupActivities.add("having deep conversation while folding clothes");
        groupActivities.add("teasing while folding clothes");
        groupActivities.add("laughing and talking while folding clothes");
        groupActivities.add("having deep conversation while ironing clothes");
        groupActivities.add("teasing while ironing clothes");
        groupActivities.add("laughing and talking while ironing clothes");
        groupActivities.add("having deep conversation while hanging some clothes");
        groupActivities.add("teasing while hanging some clothes");
        groupActivities.add("laughing and talking while hanging some clothes");
        groupActivities.add("having deep conversation while arranging clothes");
        groupActivities.add("teasing while arranging clothes");
        groupActivities.add("laughing and talking while arranging clothes");
        groupActivities.add("having deep conversation while cleaning the room");
        groupActivities.add("teasing while cleaning the room");
        groupActivities.add("laughing and talking cleaning the room");
    }
}
