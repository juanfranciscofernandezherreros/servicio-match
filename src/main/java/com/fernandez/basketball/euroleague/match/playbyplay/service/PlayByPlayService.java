package com.fernandez.basketball.euroleague.match.playbyplay.service;

import com.fernandez.basketball.euroleague.match.playbyplay.dto.MarkAsFavouriteDTO;
import com.fernandez.basketball.euroleague.match.playbyplay.dto.MatchDTO;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface PlayByPlayService {
    MatchDTO findAllMovementsFromMatchInJsonFile(String fileName) throws IOException;

    ResponseEntity<MatchDTO> download(String clubcode, String seasoncode) throws IOException;

    MatchDTO findAllPlayByPlayFromMatch(Long matchId);

    MarkAsFavouriteDTO markAsFavourite(MarkAsFavouriteDTO markAsFavouriteDTO);

    MatchDTO save(MatchDTO saveMatch);

    ResponseEntity<MatchDTO> downloadWitouthSync(String gamecode, String seasoncode) throws IOException;

    void deleteByMarkAsFavourite(String numberOfPlay, String gamecode, String seasoncode,String actualQuarter,String index);

    void addToArticle(String articleId, String numberofplay, String gamecode, String seasoncode);
}
