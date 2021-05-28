package com.fernandez.basketball.euroleague.match.header.service;

import com.fernandez.basketball.euroleague.match.header.dto.Header;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface HeaderService {
    Header findHeader(String fileName) throws IOException;
    ResponseEntity<Header> findInfoMatch(String gamecode, String seasoncode);
    Header headerWitouthSync(String gamecode, String seasoncode) throws IOException;
}
