package com.fernandez.basketball.euroleague.match.header.service;

import com.fernandez.basketball.euroleague.match.header.dto.Header;

import java.io.IOException;

public interface HeaderService {
    Header findHeader(String fileName) throws IOException;
}
