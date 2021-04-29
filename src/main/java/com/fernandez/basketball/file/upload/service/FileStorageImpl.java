package com.fernandez.basketball.file.upload.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.fernandez.basketball.commons.constants.UrlMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageImpl implements FileStorage{

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    private final Path rootLocation = Paths.get(UrlMapping.MAIN_RESOURCES);

    @Override
    public void store(final MultipartFile file , final String folderResources){
        try {
            Files.copy(file.getInputStream(), this.rootLocation.resolve(folderResources + file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
    }
}
