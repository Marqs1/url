package com.example.shortener;

public class UrlResponse {
    private String shortCode;

    public UrlResponse(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getShortCode() {
        return shortCode;
    }
}