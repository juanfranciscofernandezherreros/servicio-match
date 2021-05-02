package com.fernandez.basketball.euroleague.match.playbyplay.service;

import com.fernandez.basketball.euroleague.match.playbyplay.dto.Match;

import java.io.IOException;

public interface PlayByPlayService {
    Match findAllMovementsFromMatchInJsonFile(String fileName) throws IOException;
}
