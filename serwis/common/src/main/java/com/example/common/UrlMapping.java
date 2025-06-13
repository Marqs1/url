package com.example.common;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;

@Table("urls")
public class UrlMapping {
    @PrimaryKey
    private String shortCode;
    private String longUrl;
    private Instant createdAt;
    private Instant lastAccessedAt;
    private int ttlDays;

    public UrlMapping(String shortCode, String longUrl, Instant createdAt, Instant lastAccessedAt, int ttlDays) {
        this.shortCode = shortCode;
        this.longUrl = longUrl;
        this.createdAt = createdAt;
        this.lastAccessedAt = lastAccessedAt;
        this.ttlDays = ttlDays;
    }

    public String getShortCode() { return shortCode; }
    public String getLongUrl() { return longUrl; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getLastAccessedAt() { return lastAccessedAt; }
    public int getTtlDays() { return ttlDays; }

    public void setLastAccessedAt(Instant lastAccessedAt) { this.lastAccessedAt = lastAccessedAt; }
}
