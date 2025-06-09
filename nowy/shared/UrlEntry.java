package shared;

import java.time.Instant;

public class UrlEntry {
    private String id;
    private String originalUrl;
    private Instant createdAt;
    private Instant lastAccessed;
    private int ttlSeconds;

    public UrlEntry() {}

    public UrlEntry(String id, String originalUrl, Instant createdAt, Instant lastAccessed, int ttlSeconds) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.createdAt = createdAt;
        this.lastAccessed = lastAccessed;
        this.ttlSeconds = ttlSeconds;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getOriginalUrl() { return originalUrl; }
    public void setOriginalUrl(String originalUrl) { this.originalUrl = originalUrl; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getLastAccessed() { return lastAccessed; }
    public void setLastAccessed(Instant lastAccessed) { this.lastAccessed = lastAccessed; }

    public int getTtlSeconds() { return ttlSeconds; }
    public void setTtlSeconds(int ttlSeconds) { this.ttlSeconds = ttlSeconds; }
}
