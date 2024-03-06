package com.example.findthekiller;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class PlayerModel implements Parcelable{
    private String name, gender, role;
    private int deadImage, closeupView;
    private boolean isEliminated;

    public PlayerModel(String name, String gender, String role, int deadImage, int closeupView) {
        this.name = name;
        this.gender = gender;
        this.role = role;
        this.deadImage = deadImage;
        this.closeupView = closeupView;
        this.isEliminated = false;
    }

    protected PlayerModel(Parcel in) {
        name = in.readString();
        gender = in.readString();
        role = in.readString();
        deadImage = in.readInt();
        closeupView = in.readInt();
        isEliminated = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(gender);
        dest.writeString(role);
        dest.writeInt(deadImage);
        dest.writeInt(closeupView);
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
