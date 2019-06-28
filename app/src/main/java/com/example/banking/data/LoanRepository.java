package com.example.banking.data;

import com.example.banking.data.model.Loan;
import com.example.banking.data.model.LoanResponse;
import com.example.banking.data.model.Offer;
import com.example.banking.data.model.ProvinceResponse;
import com.example.banking.data.model.Response;
import com.example.banking.data.remote.LoanRemoteDataSource;
import com.google.gson.Gson;

import java.util.List;

public class LoanRepository {
    private static LoanRepository mInstance;
    private LoanRemoteDataSource mDataSource = new LoanRemoteDataSource();

    private LoanRepository() {
    }

    public Offer getOffer() {
        Response response = mDataSource.loadOffer();
        Gson gson = new Gson();
        return gson.fromJson(response.getJsonString(), Offer.class);
    }

    public List<String> getProvinces() {
        Response response = mDataSource.loadProvinces();
        Gson gson = new Gson();
        ProvinceResponse provinceResponse = gson.fromJson(response.getJsonString(),ProvinceResponse.class);
        return provinceResponse.getProvincesList();
    }

    public LoanResponse createLoan(Loan loan) {
        Gson gson = new Gson();
        Response response = mDataSource.createLoad(gson.toJson(loan));
        return gson.fromJson(response.getJsonString(), LoanResponse.class);
    }

    public static LoanRepository getInstance() {
        if (mInstance == null) {
            synchronized (LoanRepository.class) {
                if (mInstance == null) {
                    mInstance = new LoanRepository();
                }
            }
        }
        return mInstance;
    }
}
