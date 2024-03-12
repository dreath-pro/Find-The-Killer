package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;
import com.example.findthekiller.model.PlayerModel;

import java.util.ArrayList;
import java.util.Random;

public class Entry extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public Entry()
    {
        super("entrance", false);
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
        soloActivities.add("sitting in sofa");
        soloActivities.add("sitting in chair");
        soloActivities.add("viewing the mirror");
        soloActivities.add("watching the beautiful decorations");
        soloActivities.add("waiting at someone");
    }

    private void duoActivity()
    {
        duoActivities.add("chit chatting");
        duoActivities.add("meeting");
        duoActivities.add("starring");
        duoActivities.add("sitting in sofa");
        duoActivities.add("sitting in chair");
        duoActivities.add("teasing");
        duoActivities.add("messing");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("making out");
        duoPartnerActivities.add("flirting");
        duoPartnerActivities.add("cuddling");
        duoPartnerActivities.add("intimate kissing");
        duoPartnerActivities.add("teasing");
    }

    private void groupActivity()
    {
        groupActivities.add("sitting in chair");
        groupActivities.add("sitting in sofa");
        groupActivities.add("staying");
    }
}
