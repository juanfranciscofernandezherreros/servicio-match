package com.fernandez.basketball.match.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorage {
    public void store(MultipartFile file);
}
