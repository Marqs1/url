package com.example.shortener;

public class UrlRequest {
    private String longUrl;
    private int ttlDays = 90;

    public String getLongUrl() {
        return longUrl;
    }

    public int getTtlDays() {
        return ttlDays;
    }
}
