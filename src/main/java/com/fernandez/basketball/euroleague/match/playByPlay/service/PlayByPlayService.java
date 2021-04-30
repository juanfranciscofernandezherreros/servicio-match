package com.fernandez.basketball.euroleague.match.playByPlay.service;

import com.fernandez.basketball.euroleague.match.playByPlay.dto.Match;

import java.io.IOException;

public interface PlayByPlayService {
    Match findAllMovementsFromMatchInJsonFile(String fileName) throws IOException;
}
