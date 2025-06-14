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

    // 🔧 Konstruktor bezargumentowy - WYMAGANY przez Spring
    public UrlMapping() {}

    public UrlMapping(String shortCode, String longUrl, Instant createdAt, Instant lastAccessedAt, int ttlDays) {
        this.shortCode = shortCode;
        this.longUrl = longUrl;
        this.createdAt = createdAt;
        this.lastAccessedAt = lastAccessedAt;
        this.ttlDays = ttlDays;
    }

    public String getShortCode() { return shortCode; }
    public void setShortCode(String shortCode) { this.shortCode = shortCode; }

    public String getLongUrl() { return longUrl; }
    public void setLongUrl(String longUrl) { this.longUrl = longUrl; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getLastAccessedAt() { return lastAccessedAt; }
    public void setLastAccessedAt(Instant lastAccessedAt) { this.lastAccessedAt = lastAccessedAt; }

    public int getTtlDays() { return ttlDays; }
    public void setTtlDays(int ttlDays) { this.ttlDays = ttlDays; }
}
