package com.example.shortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ShortenerController {

    @Autowired
    private UrlRepository repository;

    @Autowired
    private ForbiddenWordChecker wordChecker;

    @PostMapping("/shorten")
    public ResponseEntity<?> shortenUrl(@RequestBody UrlRequest request) {
        if (wordChecker.containsForbiddenWord(request.getLongUrl())) {
            wordChecker.notifyKafka(request.getLongUrl());
            return ResponseEntity.badRequest().body("URL contains forbidden word");
        }

        String shortCode = Base62Encoder.encode(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);

        UrlMapping mapping = new UrlMapping(shortCode, request.getLongUrl(), Instant.now(), Instant.now(), request.getTtlDays());
        repository.save(mapping);

        return ResponseEntity.ok(new UrlResponse(shortCode));
    }
}