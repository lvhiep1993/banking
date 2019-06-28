package com.example.banking.data.model;

import com.google.gson.annotations.SerializedName;

public class Loan {

    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("national_id_number")
    private String nationalIdNumber;

    @SerializedName("monthly_income")
    private int monthlyIncome;

    @SerializedName("province")
    private String province;

    public Loan(String phoneNumber, String name, String nationalIdNumber, String province, int monthlyIncome) {
        this.phoneNumber = phoneNumber;
        this.fullName = name;
        this.nationalIdNumber = nationalIdNumber;
        this.province = province;
        this.monthlyIncome = monthlyIncome;
    }

    public String getProvince() {
        return province;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public String getNationalIdNumber() {
        return nationalIdNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
