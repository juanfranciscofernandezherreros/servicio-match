package com.fernandez.basketball.euroleague.match.boxScore.service;


import com.fernandez.basketball.euroleague.match.boxScore.dto.BoxScore;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface BoxScoreService {
    BoxScore findBoxScoreFromJson(String fileName) throws IOException;
}
