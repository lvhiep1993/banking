package com.example.banking.data.remote;

import com.example.banking.data.model.Request;
import com.example.banking.data.model.Response;
import com.example.banking.util.Constants;

public class LoanRemoteDataSource {

    public Response loadOffer() {
        Request request = new Request(Constants.METHOD_GET, Constants.OFFER_PATH, "");
        return MockApi.execute(request);
    }

    public Response loadProvinces() {
        Request request = new Request(Constants.METHOD_GET, Constants.PROVINCES_PATH, "");
        return MockApi.execute(request);
    }

    public Response createLoad(String jsonString) {
        Request request = new Request(Constants.METHOD_POST, Constants.LOANS_PATH, jsonString);
        return MockApi.execute(request);
    }
}
