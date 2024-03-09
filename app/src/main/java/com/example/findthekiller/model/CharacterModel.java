package com.example.findthekiller.model;

public class CharacterModel {
    private int image;
    private String name, gender;

    public CharacterModel()
    {

    }

    public CharacterModel(int image, String name, String gender) {
        this.image = image;
        this.name = name;
        this.gender = gender;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
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
}
