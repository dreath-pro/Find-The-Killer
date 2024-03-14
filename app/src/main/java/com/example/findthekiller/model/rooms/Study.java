package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;

import java.util.ArrayList;
import java.util.Random;

public class Study extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public Study()
    {
        super("study room", false);
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
        soloActivities.add("studying for my school");
        soloActivities.add("studying for my job");
        soloActivities.add("reading some books");
        soloActivities.add("taking a break");
        soloActivities.add("resting");
        soloActivities.add("taking a nap");
    }

    private void duoActivity()
    {
        duoActivities.add("studying for my school");
        duoActivities.add("studying for my job");
        duoActivities.add("reading some books");
        duoActivities.add("taking a break");
        duoActivities.add("resting");
        duoActivities.add("taking a nap");
        duoActivities.add("studying while chit chatting");
        duoActivities.add("messing");
        duoActivities.add("teasing");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("hugging while resting");
        duoPartnerActivities.add("studying while holding hands");
        duoPartnerActivities.add("teasing");
        duoPartnerActivities.add("making out");
        duoPartnerActivities.add("flirting");
        duoPartnerActivities.add("cuddling");
        duoPartnerActivities.add("sensual touching");
        duoPartnerActivities.add("deep kissing");
        duoPartnerActivities.add("complimenting");
        duoPartnerActivities.add("deep intimate sex");
        duoPartnerActivities.add("doing blowjob");
    }

    private void groupActivity()
    {
        groupActivities.add("studying for my school");
        groupActivities.add("studying for my job");
        groupActivities.add("reading some books");
        groupActivities.add("taking a break");
        groupActivities.add("resting");
        groupActivities.add("taking a nap");
        groupActivities.add("studying while chit chatting");
        groupActivities.add("messing");
        groupActivities.add("teasing");
    }
}
