package com.example.findthekiller;

public class Characters {
    private int standImage, deadImage, closeView;
    private String name, gender;

    public Characters()
    {

    }

    public Characters(int standImage, int deadImage, int closeView, String name, String gender) {
        this.standImage = standImage;
        this.deadImage = deadImage;
        this.closeView = closeView;
        this.name = name;
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

    public int getCloseView() {
        return closeView;
    }

    public void setCloseView(int closeView) {
        this.closeView = closeView;
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
}
