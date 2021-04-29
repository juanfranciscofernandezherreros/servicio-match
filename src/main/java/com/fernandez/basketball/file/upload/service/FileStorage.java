package com.fernandez.basketball.file.upload.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorage {
    public void store(final MultipartFile file,String playByPlay);
}
