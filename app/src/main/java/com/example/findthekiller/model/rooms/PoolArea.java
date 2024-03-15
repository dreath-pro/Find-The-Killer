package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;

import java.util.ArrayList;
import java.util.Random;

public class PoolArea extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public PoolArea()
    {
        super("pool area", false);
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
        soloActivities.add("sitting in flat beach chair");
        soloActivities.add("enjoying my time swimming");
        soloActivities.add("preparing some barbeque");
        soloActivities.add("eating some barbeque with juice");
        soloActivities.add("chilling in the heat of sun");
        soloActivities.add("playing in the pool");
        soloActivities.add("having good time");
        soloActivities.add("bathing");
        soloActivities.add("craving some other snacks");
    }

    private void duoActivity()
    {
        duoActivities.add("sitting in flat beach chair");
        duoActivities.add("enjoying my time swimming");
        duoActivities.add("preparing some barbeque");
        duoActivities.add("eating some barbeque with juice");
        duoActivities.add("chilling in the heat of sun");
        duoActivities.add("playing in the pool");
        duoActivities.add("having good time");
        duoActivities.add("bathing");
        duoActivities.add("happily chatting");
        duoActivities.add("having party");
        duoActivities.add("craving some other snacks");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("making out");
        duoPartnerActivities.add("flirting");
        duoPartnerActivities.add("cuddling");
        duoPartnerActivities.add("intimate kissing");
        duoPartnerActivities.add("teasing");
        duoPartnerActivities.add("having quickie sex");
        duoPartnerActivities.add("complimenting");
    }

    private void groupActivity()
    {
        groupActivities.add("sitting in flat beach chair");
        groupActivities.add("enjoying my time swimming");
        groupActivities.add("preparing some barbeque");
        groupActivities.add("eating some barbeque with juice");
        groupActivities.add("chilling in the heat of sun");
        groupActivities.add("playing in the pool");
        groupActivities.add("having good time");
        groupActivities.add("bathing");
        groupActivities.add("happily chatting");
        groupActivities.add("having party");
        groupActivities.add("craving some other snacks");
    }
}
