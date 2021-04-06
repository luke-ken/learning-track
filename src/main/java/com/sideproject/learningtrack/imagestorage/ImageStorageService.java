package com.sideproject.learningtrack.imagestorage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ImageStorageService {
    void init();

    void store(MultipartFile file);

    Resource load(String fileName);

    void deleteAll();
}
