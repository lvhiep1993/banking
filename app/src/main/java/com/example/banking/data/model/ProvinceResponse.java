package com.example.banking.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProvinceResponse {

    @SerializedName("total")
    private long total;

    @SerializedName("provinces_list")
    private List<String> provincesList;

    public List<String> getProvincesList() {
        return provincesList;
    }
}
