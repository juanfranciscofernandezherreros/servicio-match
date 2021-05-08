package com.fernandez.basketball.euroleague.match.playbyplay.service;

import com.fernandez.basketball.euroleague.match.playbyplay.dto.MatchDTO;
import com.fernandez.basketball.euroleague.match.playbyplay.entity.Match;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface PlayByPlayService {
    MatchDTO findAllMovementsFromMatchInJsonFile(String fileName) throws IOException;
    Match save(MatchDTO saveMatch);
    ResponseEntity<MatchDTO> download(String clubcode, String seasoncode);
    MatchDTO findAllPlayByPlayFromMatch(Long matchId);
}
