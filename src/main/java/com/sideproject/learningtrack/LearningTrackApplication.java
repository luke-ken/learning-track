package com.sideproject.learningtrack;

import com.sideproject.learningtrack.domain.user.Role;
import com.sideproject.learningtrack.imagestorage.ImageStorageService;
import com.sideproject.learningtrack.imagestorage.StorageProperties;
import com.sideproject.learningtrack.service.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class LearningTrackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningTrackApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ImageStorageService storageService, UserService userService) {
        return (args) -> {
            storageService.init();

            Set<Role> role = new HashSet<>();

            role.add(Role.ROLE_USER);
            userService.signup("guest", "guest", role);
        };
    }

}
