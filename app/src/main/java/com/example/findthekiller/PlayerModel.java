package com.example.findthekiller;

import java.util.ArrayList;

public class PlayerModel {
    String name, gender;
    int image;

    public PlayerModel(String name, String gender, int image) {

        this.name = name;
        this.gender = gender;
        this.image = image;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
