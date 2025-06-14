package com.example.cleaner;

import com.example.common.UrlMapping;
import com.example.common.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Iterator;

@Component
public class UrlCleaner {

    @Autowired
    private UrlRepository repository;

    @Value("${cleaner.ttl.days}")
    private int ttlDays;

    @Scheduled(fixedRate = 86400000) // run every 24 hours
    public void cleanOldUrls() {
        Iterable<UrlMapping> urls = repository.findAll();
        Instant now = Instant.now();
        Iterator<UrlMapping> iterator = urls.iterator();
        while (iterator.hasNext()) {
            UrlMapping mapping = iterator.next();
            Instant expiry = mapping.getCreatedAt().plusSeconds((long) ttlDays * 86400);
            if (now.isAfter(expiry)) {
                repository.delete(mapping);
                System.out.println("Deleted expired URL: " + mapping.getShortCode());
            }
        }
    }
}
