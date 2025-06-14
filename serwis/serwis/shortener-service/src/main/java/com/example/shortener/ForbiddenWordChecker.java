package com.example.shortener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Service
public class ForbiddenWordChecker {

    @Value("${app.forbiddenWords}")
    private String forbiddenWordsRaw;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ForbiddenWordChecker(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean containsForbiddenWord(String url) {
        List<String> words = Arrays.asList(forbiddenWordsRaw.split(","));
        return words.stream().anyMatch(word -> url.toLowerCase().contains(word));
    }

    public void notifyKafka(String url) {
        kafkaTemplate.send("forbidden-urls", "Detected forbidden URL: " + url);
    }
}
