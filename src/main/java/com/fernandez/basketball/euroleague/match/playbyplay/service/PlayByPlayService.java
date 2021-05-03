package com.fernandez.basketball.euroleague.match.playbyplay.service;

import com.fernandez.basketball.euroleague.match.playbyplay.dto.Match;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface PlayByPlayService {
    Match findAllMovementsFromMatchInJsonFile(String fileName) throws IOException;
    ResponseEntity<Match> download(String clubcode, String seasoncode);
}
