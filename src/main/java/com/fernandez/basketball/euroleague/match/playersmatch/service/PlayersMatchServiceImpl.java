package com.fernandez.basketball.euroleague.match.playersmatch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.playersmatch.dto.PlayerMatch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayersMatchServiceImpl implements PlayersMatchService {

    @Override
    public PlayerMatch[] findPlayersMatchByTeam(String fileName)  throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        PlayerMatch[] playerMatch = objectMapper.readValue(new FileInputStream(UrlMapping.MAIN_RESOURCES+UrlMapping.PLAYERSMATCH+"/"+fileName+".json"),PlayerMatch[].class );
        return playerMatch;
    }
}
