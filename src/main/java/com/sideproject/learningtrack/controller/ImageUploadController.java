package com.sideproject.learningtrack.controller;

import com.sideproject.learningtrack.imagestorage.ImageStorageService;
import com.sideproject.learningtrack.dto.ImageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageUploadController {

    private final ImageStorageService storageService;

    private final String IMAGE_URL = "/files/image";

    @Autowired
    public ImageUploadController(ImageStorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping(value = "/upload/image")
    public ResponseEntity<ImageInfo> handleImageUpload(@RequestParam("file")MultipartFile file) {
        storageService.store(file);

        String imageUrl = "http://localhost:9000" + IMAGE_URL + "/" + file.getOriginalFilename();
        ImageInfo imageInfo = new ImageInfo(imageUrl);

        return ResponseEntity.ok().body(imageInfo);
    }

    @GetMapping(value = IMAGE_URL + "/{filename:.+}")
    public ResponseEntity<Resource> serveImage(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline").body(file);
    }

}
