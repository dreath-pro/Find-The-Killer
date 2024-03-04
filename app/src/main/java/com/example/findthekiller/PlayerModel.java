package com.example.findthekiller;

import java.util.ArrayList;

public class PlayerModel {
    String name, gender;
    int standImage, deadImage, closeupView;

    public PlayerModel(String name, String gender, int standImage, int deadImage, int closeupView) {
        this.name = name;
        this.gender = gender;
        this.standImage = standImage;
        this.deadImage = deadImage;
        this.closeupView = closeupView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getStandImage() {
        return standImage;
    }

    public void setStandImage(int standImage) {
        this.standImage = standImage;
    }

    public int getDeadImage() {
        return deadImage;
    }

    public void setDeadImage(int deadImage) {
        this.deadImage = deadImage;
    }

    public int getCloseupView() {
        return closeupView;
    }

    public void setCloseupView(int closeupView) {
        this.closeupView = closeupView;
    }
}
