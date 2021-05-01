package com.fernandez.basketball.euroleague.match.comparission.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.comparission.dto.Comparission;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ComparissionServiceImpl implements ComparissionService{
    @Override
    public Comparission findComparisionFromJson(String fileName) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        Comparission comparission = new ObjectMapper().readValue(new FileInputStream(UrlMapping.MAIN_RESOURCES+UrlMapping.COMPARISSION+"/"+fileName+".json"), Comparission.class );
        return comparission;
    }
}
