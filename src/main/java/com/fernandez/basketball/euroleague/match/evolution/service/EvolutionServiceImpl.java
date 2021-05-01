package com.fernandez.basketball.euroleague.match.evolution.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.evolution.dto.Evolution;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class EvolutionServiceImpl implements  EvolutionService{

    @Override
    public Evolution findAllEvolutionFromMatchInJsonFile(String fileName) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        Evolution evolution = new ObjectMapper().readValue(new FileInputStream(UrlMapping.MAIN_RESOURCES+UrlMapping.EVOLUTION+"/"+fileName+".json"), Evolution.class );
        return evolution;
    }
}
