package com.example.banking.data.remote;

import com.example.banking.data.model.Loan;
import com.example.banking.data.model.LoanResponse;
import com.example.banking.data.model.Request;
import com.example.banking.data.model.Response;
import com.example.banking.util.Constants;
import com.google.gson.Gson;

class MockApi {

    static Response execute(Request request) {
        String mProvincesResponse = "{\n" +
                "\"total\": 10,\n" +
                "\"provinces_list\": [\n" +
                "\"An Giang\",\n" +
                "\"Bắc Giang\",\n" +
                "\"Bắc Kạn\",\n" +
                "\"Bạc Liêu\",\n" +
                "\"Bắc Ninh\",\n" +
                "\"Bà Rịa - Vũng Tàu\",\n" +
                "\"Bến Tre\",\n" +
                "\"Bình Định\",\n" +
                "\"Bình Dương\",\n" +
                "\"Bình Phước\"\n" +
                "]\n" +
                "}";
        String mOfferResponse = "{\n" +
                "\"min_amount\": 30000000,\n" +
                "\"max_amount\": 100000000,\n" +
                "\"min_tenor\": 6,\n" +
                "\"max_tenor\": 18,\n" +
                "\"interest_rate\": 19.99,\n" +
                "\"bank\": {\n" +
                "\"name\": \"Vietcombank\",\n" +
                "\"logo\": \"https://www.vietcombank.com.vn/images/logo30.png\"\n" +
                "}\n" +
                "}";
        String mLoansResponse = "{\n" +
                "\"id\": 1,\n" +
                "\"phone_number\": \"0987000001\",\n" +
                "\"full_name\": \"Nguyễn Văn Tuấn\",\n" +
                "\"national_id_number\": \"111111111\",\n" +
                "\"monthly_income\": 3000001,\n" +
                "\"province\": \"An Giang\"\n" +
                "}";
        switch (request.getPath()) {
            case Constants.OFFER_PATH:
                if (request.getMethod().equals(Constants.METHOD_GET))
                    return new Response(Constants.RESPONSE_CODE, mOfferResponse);
                break;
            case Constants.PROVINCES_PATH:
                if (request.getMethod().equals(Constants.METHOD_GET))
                    return new Response(Constants.RESPONSE_CODE, mProvincesResponse);
                break;
            default:
                if (request.getMethod().equals(Constants.METHOD_POST)) {
                    Gson gson = new Gson();
                    Loan loanRequest = gson.fromJson(request.getBody(), Loan.class);
                    LoanResponse loanResponse = new LoanResponse(loanRequest);
                    return new Response(Constants.RESPONSE_CODE, gson.toJson(loanResponse));
                }
                break;
        }
        return new Response(Constants.RESPONSE_CODE, "");
    }
}
