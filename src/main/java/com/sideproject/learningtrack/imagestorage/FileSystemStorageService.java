package com.sideproject.learningtrack.imagestorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageService implements ImageStorageService {

    private final Path rootLocation;

    @Autowired
    public FileSystemStorageService(StorageProperties properties) {
        System.out.println(properties.getLocation());
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage. \n", e);
        }
    }

    @Override
    public void store(MultipartFile file) {
        try {
            Path destinationFile = rootLocation.resolve(Paths.get(file.getOriginalFilename())).normalize().toAbsolutePath();
            InputStream inputStream = file.getInputStream();

            Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e) {
            throw new RuntimeException("Could not store requested image file.\n", e);
        }
    }

    @Override
    public Resource load(String fileName) {
        try {
            Path file = rootLocation.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            return resource;
        }
        catch (MalformedURLException e) {
            throw new RuntimeException("Could not read image file.\n", e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
}
