package com.example.findthekiller.model;

import java.util.ArrayList;

public abstract class HouseModel {
    private String roomName;
    private boolean isLock;
    private ArrayList<PlayerModel> occupants = new ArrayList<>();

    public HouseModel(String roomName, boolean isLock) {
        this.roomName = roomName;
        this.isLock = isLock;
    }

    public abstract String getActivity(int groupType);

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public boolean isLock() {
        return isLock;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }

    public ArrayList<PlayerModel> getOccupants()
    {
        return occupants;
    }

    public void setOccupants(ArrayList<PlayerModel> occupants)
    {
        this.occupants = occupants;
    }

    public void addOccupants(PlayerModel occupants)
    {
        this.occupants.add(occupants);
    }

    public void clearOccupants()
    {
        this.occupants.clear();
    }
}
