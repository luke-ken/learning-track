package com.sideproject.learningtrack.imagestorage;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "storage")
public class StorageProperties {

    @Getter
    @Setter
    private String location;

}
