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

    //    private void initializeRooms()
//    {
//        rooms.add("Second Bedroom");
//        rooms.add("Second Bedroom Wardrobe");
//        rooms.add("Second Bath");
//        rooms.add("Third Bedroom");
//        rooms.add("Third Bedroom Wardrobe");
//        rooms.add("Third Bath");
//        rooms.add("Outdoor Kitchen");
//        rooms.add("Morning Bar");
//        rooms.add("Great Room");
//        rooms.add("Kitchen");
//        rooms.add("Dinette");
//        rooms.add("Wet Bar");
//        rooms.add("First Covered Lanai");
//        rooms.add("Second Covered Lanai");
//        rooms.add("Master Suite");
//        rooms.add("Sitting Area");
//        rooms.add("Pool Area");
//        rooms.add("Backyard");
//    }
}
