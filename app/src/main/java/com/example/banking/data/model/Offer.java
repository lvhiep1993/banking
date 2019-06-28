package com.example.banking.data.model;
import com.google.gson.annotations.SerializedName;

public class Offer {

    @SerializedName("min_amount")
    private long minAmount;

    @SerializedName("max_amount")
    private long maxAmount;

    @SerializedName("min_tenor")
    private int minTenor;

    @SerializedName("max_tenor")
    private int maxTenor;

    @SerializedName("interest_rate")
    private float interestRate;

    @SerializedName("bank")
    private Bank bank = null;


    public float getInterestRate() {
        return interestRate;
    }

    public int getMaxTenor() {
        return maxTenor;
    }

    public int getMinTenor() {
        return minTenor;
    }

    public long getMaxAmount() {
        return maxAmount;
    }

    public long getMinAmount() {
        return minAmount;
    }

    public Bank getBank() {
        return bank;
    }

    public class Bank {

        @SerializedName("logo")
        private String logo;

        @SerializedName("name")
        private String name;

        public String getLogo() {
            return logo;
        }

        public String getName() {
            return name;
        }

    }
}
