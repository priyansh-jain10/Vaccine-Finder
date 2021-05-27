package com.example.vaccine_finder.model;

import android.os.Parcel;
import android.os.Parcelable;

public class VaccineModel implements Parcelable {
    private String Hospital_name;
    private String address;
    private String District;
    private int minagelimit;
    private String Vaccine_Name ;
    private String available_from;
    private String available_till;
    private String fee;
    private int dose1_capacity;
    private int dose2_capacity;

    public VaccineModel() {
    }

    protected VaccineModel(Parcel in) {
        Hospital_name = in.readString();
        address = in.readString();
        District = in.readString();
        minagelimit = in.readInt();
        Vaccine_Name = in.readString();
        available_from = in.readString();
        available_till = in.readString();
        fee = in.readString();
        dose1_capacity = in.readInt();
        dose2_capacity = in.readInt();
    }

    public static final Creator<VaccineModel> CREATOR = new Creator<VaccineModel>() {
        @Override
        public VaccineModel createFromParcel(Parcel in) {
            return new VaccineModel(in);
        }

        @Override
        public VaccineModel[] newArray(int size) {
            return new VaccineModel[size];
        }
    };

    public String getHospital_name() {
        return Hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        Hospital_name = hospital_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public int getMinagelimit() {
        return minagelimit;
    }

    public void setMinagelimit(int minagelimit) {
        this.minagelimit = minagelimit;
    }

    public String getVaccine_Name() {
        return Vaccine_Name;
    }

    public void setVaccine_Name(String vaccine_Name) {
        Vaccine_Name = vaccine_Name;
    }

    public String getAvailable_from() {
        return available_from;
    }

    public void setAvailable_from(String available_from) {
        this.available_from = available_from;
    }

    public String getAvailable_till() {
        return available_till;
    }

    public void setAvailable_till(String available_till) {
        this.available_till = available_till;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public int getDose1_capacity() {
        return dose1_capacity;
    }

    public void setDose1_capacity(int dose1_capacity) {
        this.dose1_capacity = dose1_capacity;
    }

    public int getDose2_capacity() {
        return dose2_capacity;
    }

    public void setDose2_capacity(int dose2_capacity) {
        this.dose2_capacity = dose2_capacity;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Hospital_name);
        dest.writeString(address);
        dest.writeString(District);
        dest.writeInt(minagelimit);
        dest.writeString(Vaccine_Name);
        dest.writeString(available_from);
        dest.writeString(available_till);
        dest.writeString(fee);
        dest.writeInt(dose1_capacity);
        dest.writeInt(dose2_capacity);
    }
}
