package com.example.findthekiller.model.rooms;

import com.example.findthekiller.model.HouseModel;

import java.util.ArrayList;
import java.util.Random;

public class GreatRoom extends HouseModel {
    private String roomActivities;

    private ArrayList<String> soloActivities = new ArrayList<>();
    private ArrayList<String> duoActivities = new ArrayList<>();
    private ArrayList<String> duoPartnerActivities = new ArrayList<>();
    private ArrayList<String> groupActivities = new ArrayList<>();

    public GreatRoom()
    {
        super("great room", false);
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
        soloActivities.add("scrolling in my phone");
        soloActivities.add("sitting and chilling");
        soloActivities.add("watching netflix and chill");
        soloActivities.add("watching TV");
        soloActivities.add("watching movies");
        soloActivities.add("eating some snacks while watching");
        soloActivities.add("viewing some paintings");
        soloActivities.add("viewing some sculptures");
        soloActivities.add("watching the nature outside");
        soloActivities.add("composing in piano");
        soloActivities.add("sculpting");
        soloActivities.add("creating diy arts");
        soloActivities.add("relaxing in sofa while scrolling through phone");
        soloActivities.add("taking a catnap in sofa");
        soloActivities.add("painting");
    }

    private void duoActivity()
    {
        duoActivities.add("scrolling in my phone");
        duoActivities.add("sitting and chilling");
        duoActivities.add("watching netflix and chill");
        duoActivities.add("watching TV");
        duoActivities.add("watching movies");
        duoActivities.add("eating some snacks while watching");
        duoActivities.add("viewing some paintings");
        duoActivities.add("viewing some sculptures");
        duoActivities.add("watching the nature outside");
        duoActivities.add("composing in piano");
        duoActivities.add("sculpting");
        duoActivities.add("creating diy arts");
        duoActivities.add("painting");
        duoActivities.add("relaxing in sofa while scrolling through phone");
        duoActivities.add("taking a catnap in sofa");
        duoActivities.add("talking");
        duoActivities.add("deep talking");
        duoActivities.add("having some company");
        duoActivities.add("playing some cards");
        duoActivities.add("playing monopoly");
        duoActivities.add("playing chess");
    }

    private void duoPartnerActivity()
    {
        duoPartnerActivities.add("leaning in shoulder while watching TV");
        duoPartnerActivities.add("flirting");
        duoPartnerActivities.add("cuddling");
        duoPartnerActivities.add("intimate kissing");
        duoPartnerActivities.add("complimenting");
        duoPartnerActivities.add("quick kissing");
        duoPartnerActivities.add("sweet talking");
        duoPartnerActivities.add("seductively whispering");
    }

    private void groupActivity()
    {
        groupActivities.add("scrolling in my phone");
        groupActivities.add("sitting and chilling");
        groupActivities.add("watching netflix and chill");
        groupActivities.add("watching TV");
        groupActivities.add("watching movies");
        groupActivities.add("eating some snacks while watching");
        groupActivities.add("viewing some paintings");
        groupActivities.add("viewing some sculptures");
        groupActivities.add("watching the nature outside");
        groupActivities.add("composing in piano");
        groupActivities.add("sculpting");
        groupActivities.add("creating diy arts");
        groupActivities.add("painting");
        groupActivities.add("relaxing in sofa while scrolling through phone");
        groupActivities.add("taking a catnap in sofa");
        groupActivities.add("talking");
        groupActivities.add("deep talking");
        groupActivities.add("having some company");
        groupActivities.add("playing some cards");
        groupActivities.add("playing monopoly");
        groupActivities.add("playing chess");
    }
}
