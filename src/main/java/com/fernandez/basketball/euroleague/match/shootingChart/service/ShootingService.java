package com.fernandez.basketball.euroleague.match.shootingChart.service;

import com.fernandez.basketball.euroleague.match.shootingChart.dto.Shooting;

import java.io.IOException;

public interface ShootingService {
    Shooting findAllShootingFromMatchInJsonFile(String fileName) throws IOException;
}
