package com.fernandez.basketball.euroleague.match.boxscore.service;


import com.fernandez.basketball.euroleague.match.boxscore.dto.BoxScore;

import java.io.IOException;

public interface BoxScoreService {
    BoxScore findBoxScoreFromJson(String fileName) throws IOException;

    BoxScore findBoxScoreWitouthSync(String gameCode, String seassonCode) throws IOException;
}
