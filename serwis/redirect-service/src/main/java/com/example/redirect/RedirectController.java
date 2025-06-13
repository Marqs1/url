package com.example.redirect;

import com.example.common.UrlMapping;
import com.example.common.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.Instant;

@RestController
public class RedirectController {

    @Autowired
    private UrlRepository repository;

    @GetMapping("/{shortCode}")
    public ResponseEntity<?> redirect(@PathVariable String shortCode) {
        UrlMapping mapping = repository.findById(shortCode).orElse(null);
        if (mapping == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Short URL not found");
        }

        Instant expiry = mapping.getCreatedAt().plusSeconds(mapping.getTtlDays() * 86400L);
        if (Instant.now().isAfter(expiry)) {
            return ResponseEntity.status(HttpStatus.GONE).body("URL has expired");
        }

        mapping.setLastAccessedAt(Instant.now());
        repository.save(mapping);

        RedirectView view = new RedirectView(mapping.getLongUrl());
        return new ResponseEntity<>(view.getUrl(), HttpStatus.FOUND);
    }
}