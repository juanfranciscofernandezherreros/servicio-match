package com.fernandez.basketball.euroleague.match.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorage {
    public void store(MultipartFile file);
}
