package com.example.banking.data.model;

import com.google.gson.annotations.SerializedName;

public class LoanResponse {

    @SerializedName("id")
    private int id;

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

    public LoanResponse(Loan loan) {
        this.id = 1;
        this.phoneNumber = loan.getPhoneNumber();
        this.fullName = loan.getFullName();
        this.nationalIdNumber = loan.getNationalIdNumber();
        this.monthlyIncome = loan.getMonthlyIncome();
        this.province = loan.getProvince();
    }

}
