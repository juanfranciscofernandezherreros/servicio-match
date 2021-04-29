package com.fernandez.basketball.euroleague.match.controller;

import com.fernandez.basketball.euroleague.match.service.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class UploadFileController {

    @Autowired
    private FileStorage fileStorage;

    @RequestMapping(value = "/file/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String myService(@RequestParam("file") MultipartFile file) throws Exception {
        try {
            fileStorage.store(file);
            return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
        } catch (Exception e) {
            return "Fail! -> uploaded filename: " + file.getOriginalFilename();
        }
    }

}