package com.fernandez.basketball.euroleague.match.evolution.service;

import com.fernandez.basketball.euroleague.match.evolution.dto.Evolution;

import java.io.IOException;

public interface EvolutionService {
    Evolution findAllEvolutionFromMatchInJsonFile(String fileName) throws IOException;
    Evolution evolutionWitouthSync(String gameCode, String seassonCode) throws IOException;
}
