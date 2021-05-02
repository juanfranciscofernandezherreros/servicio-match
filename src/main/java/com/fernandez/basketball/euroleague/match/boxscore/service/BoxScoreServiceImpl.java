package com.fernandez.basketball.euroleague.match.boxscore.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.boxscore.dto.BoxScore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoxScoreServiceImpl implements BoxScoreService{
    @Override
    public BoxScore findBoxScoreFromJson(String fileName) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        BoxScore evolution = new ObjectMapper().readValue(new FileInputStream(UrlMapping.MAIN_RESOURCES+UrlMapping.BOXSCORE+"/"+fileName+".json"),BoxScore.class);
        return evolution;
    }
}
