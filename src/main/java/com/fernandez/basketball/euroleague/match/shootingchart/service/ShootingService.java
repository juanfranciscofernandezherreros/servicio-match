package com.fernandez.basketball.euroleague.match.shootingchart.service;

import com.fernandez.basketball.euroleague.match.shootingchart.dto.Shooting;

import java.io.IOException;

public interface ShootingService {
    Shooting findAllShootingFromMatchInJsonFile(String fileName) throws IOException;

    Shooting findAllShootingWitouthSync(String gameCode, String seassonCode) throws IOException;
}
