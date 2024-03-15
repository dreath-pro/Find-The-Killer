package com.example.findthekiller.model;

import java.util.ArrayList;

public abstract class HouseModel {
    private String roomName;
    private boolean isLock;

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
}
