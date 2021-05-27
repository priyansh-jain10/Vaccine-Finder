package com.example.vaccine_finder.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class AgeArrayListModel implements Parcelable {
    public AgeArrayListModel() {
    }

    protected AgeArrayListModel(Parcel in) {
        eighteenyearsAL = in.createTypedArrayList(VaccineModel.CREATOR);
        fortyfiveAL = in.createTypedArrayList(VaccineModel.CREATOR);
    }

    public static final Creator<AgeArrayListModel> CREATOR = new Creator<AgeArrayListModel>() {
        @Override
        public AgeArrayListModel createFromParcel(Parcel in) {
            return new AgeArrayListModel(in);
        }

        @Override
        public AgeArrayListModel[] newArray(int size) {
            return new AgeArrayListModel[size];
        }
    };

    public ArrayList<VaccineModel> getEighteenyearsAL() {
        return eighteenyearsAL;
    }

    public void setEighteenyearsAL(ArrayList<VaccineModel> eighteenyearsAL) {
        this.eighteenyearsAL = eighteenyearsAL;
    }

    public ArrayList<VaccineModel> getFortyfiveAL() {
        return fortyfiveAL;
    }

    public void setFortyfiveAL(ArrayList<VaccineModel> fortyfiveAL) {
        this.fortyfiveAL = fortyfiveAL;
    }

    private ArrayList<VaccineModel> eighteenyearsAL;
    private ArrayList<VaccineModel> fortyfiveAL;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(eighteenyearsAL);
        dest.writeTypedList(fortyfiveAL);
    }
}
