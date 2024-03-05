package com.example.findthekiller;

import java.util.ArrayList;

public class PlayerModel {
    private String name, gender, role;
    private int standImage, deadImage, closeupView;
    private boolean isEliminated;

    public PlayerModel(String name, String gender, String role, int standImage, int deadImage, int closeupView) {
        this.name = name;
        this.gender = gender;
        this.role = role;
        this.standImage = standImage;
        this.deadImage = deadImage;
        this.closeupView = closeupView;
        this.isEliminated = false;
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

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
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

    public boolean isEliminated() {
        return isEliminated;
    }

    public void setEliminated(boolean eliminated) {
        isEliminated = eliminated;
    }
}
