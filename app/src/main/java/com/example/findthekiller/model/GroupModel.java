package com.example.findthekiller.model;

import java.util.ArrayList;

public class GroupModel {
    private ArrayList<ArrayList<PlayerModel>> groupsList = new ArrayList<>();
    private ArrayList<PlayerModel> groupColumn = new ArrayList<>();

    public GroupModel()
    {

    }

    public void resetGroup()
    {
        groupColumn.clear();
        groupsList.clear();
    }

    public void createGroup()
    {
        ArrayList<PlayerModel> newGroupRow = new ArrayList<>(groupColumn);
        groupsList.add(newGroupRow);
    }

    public void addToGroup(PlayerModel player)
    {
        groupColumn.add(player);
    }
}
