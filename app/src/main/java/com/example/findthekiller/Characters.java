package com.example.findthekiller;

public class Characters {
    private int deadImage, closeView;
    private String name, gender;

    public Characters()
    {

    }

    public Characters(int deadImage, int closeView, String name, String gender) {
        this.deadImage = deadImage;
        this.closeView = closeView;
        this.name = name;
        this.gender = gender;
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
