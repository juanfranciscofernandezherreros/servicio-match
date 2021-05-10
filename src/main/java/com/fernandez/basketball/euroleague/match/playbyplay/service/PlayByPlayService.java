package com.fernandez.basketball.euroleague.match.playbyplay.service;

import com.fernandez.basketball.euroleague.match.playbyplay.dto.MarkAsFavouriteDTO;
import com.fernandez.basketball.euroleague.match.playbyplay.dto.MatchDTO;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface PlayByPlayService {
    MatchDTO findAllMovementsFromMatchInJsonFile(String fileName) throws IOException;
    ResponseEntity<MatchDTO> download(String clubcode, String seasoncode);
    MatchDTO findAllPlayByPlayFromMatch(Long matchId);
    void markAsFavourite(MarkAsFavouriteDTO markAsFavouriteDTO,Long matchId);
}
