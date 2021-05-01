package com.fernandez.basketball.euroleague.match.header.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.header.dto.Header;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class HeaderServiceImpl implements HeaderService{
    @Override
    public Header findHeader(String fileName) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        Header header = new ObjectMapper().readValue(new FileInputStream(UrlMapping.MAIN_RESOURCES+UrlMapping.HEADER+"/"+fileName+".json"), Header.class );
        return header;
    }
}
