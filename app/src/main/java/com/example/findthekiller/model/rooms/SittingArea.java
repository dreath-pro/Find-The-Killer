package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;

import java.util.ArrayList;
import java.util.Random;

public class SittingArea extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public SittingArea()
    {
        super("sitting area", false);
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
        soloActivities.add("sitting in chilling");
        soloActivities.add("sitting in the sofa");
        soloActivities.add("scrolling through my phone");
        soloActivities.add("eating some snack");
        soloActivities.add("taking a rest");
        soloActivities.add("taking a break");
        soloActivities.add("taking a nap");
        soloActivities.add("reading some books");
        soloActivities.add("reading some novels");
        soloActivities.add("reading some manga");
        soloActivities.add("reading some comics");
    }

    private void duoActivity()
    {
        duoActivities.add("sitting in chilling");
        duoActivities.add("sitting in the sofa");
        duoActivities.add("scrolling through my phone");
        duoActivities.add("eating some snack");
        duoActivities.add("taking a rest");
        duoActivities.add("taking a break");
        duoActivities.add("taking a nap");
        duoActivities.add("reading some books");
        duoActivities.add("reading some novels");
        duoActivities.add("reading some manga");
        duoActivities.add("reading some comics");
        duoActivities.add("talking");
        duoActivities.add("making fun");
        duoActivities.add("teasing");
        duoActivities.add("messing around");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("making out");
        duoPartnerActivities.add("touching body sexually");
        duoPartnerActivities.add("flirting");
        duoPartnerActivities.add("cuddling");
        duoPartnerActivities.add("intimate kissing");
        duoPartnerActivities.add("teasing");
        duoPartnerActivities.add("complimenting");
    }

    private void groupActivity()
    {
        groupActivities.add("sitting in chilling");
        groupActivities.add("sitting in the sofa");
        groupActivities.add("scrolling through my phone");
        groupActivities.add("eating some snack");
        groupActivities.add("taking a rest");
        groupActivities.add("taking a break");
        groupActivities.add("taking a nap");
        groupActivities.add("reading some books");
        groupActivities.add("reading some novels");
        groupActivities.add("reading some manga");
        groupActivities.add("reading some comics");
        groupActivities.add("talking");
        groupActivities.add("making fun");
        groupActivities.add("teasing");
        groupActivities.add("messing around");
    }
}
