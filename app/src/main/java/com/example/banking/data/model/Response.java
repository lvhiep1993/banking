package com.example.banking.data.model;

public class Response {
    private int code;
    private String jsonString;

    public Response(int code, String jsonString) {
        this.code = code;
        this.jsonString = jsonString;
    }

    public String getJsonString() {
        return jsonString;
    }
}
