package com.fernandez.basketball.euroleague.match.points.service;

import com.fernandez.basketball.euroleague.match.points.dto.Points;

import java.io.IOException;

public interface PointsService {
    Points findAllPointsFromMatchInJsonFile(String fileName) throws IOException;

    Points findPointsWitouthSync(String gameCode, String seassonCode) throws IOException;
}
