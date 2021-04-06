package com.sideproject.learningtrack;

import com.sideproject.learningtrack.imagestorage.ImageStorageService;
import com.sideproject.learningtrack.imagestorage.StorageProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.time.ZoneId;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class LearningTrackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningTrackApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ImageStorageService storageService) {
        return (args) -> {
            storageService.init();
        };
    }

}
