package com.example.findthekiller.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class PlayerModel implements Parcelable{
    private String name, gender, role;
    private int image;
    private boolean isEliminated;
    private ArrayList<PlayerModel> groups = new ArrayList<>();
    private String room;
    private String activity;

    public PlayerModel(String name, String gender, String role, int image) {
        this.name = name;
        this.gender = gender;
        this.role = role;
        this.image = image;

        isEliminated = false;
        groups = null;
        room = "";
        activity = "";
    }

    protected PlayerModel(Parcel in) {
        name = in.readString();
        gender = in.readString();
        role = in.readString();
        image = in.readInt();
        isEliminated = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(gender);
        dest.writeString(role);
        dest.writeInt(image);
        dest.writeByte((byte) (isEliminated ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<PlayerModel> CREATOR = new Parcelable.Creator<PlayerModel>() {
        @Override
        public PlayerModel createFromParcel(Parcel in) {
            return new PlayerModel(in);
        }

        @Override
        public PlayerModel[] newArray(int size) {
            return new PlayerModel[size];
        }
    };

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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isEliminated() {
        return isEliminated;
    }

    public void setEliminated(boolean eliminated) {
        isEliminated = eliminated;
    }

    public void addGroup(PlayerModel player)
    {
        groups.add(player);
    }

    public void clearGroup()
    {
        groups.clear();
    }

    public ArrayList<PlayerModel> getGroups() {
        return groups;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
