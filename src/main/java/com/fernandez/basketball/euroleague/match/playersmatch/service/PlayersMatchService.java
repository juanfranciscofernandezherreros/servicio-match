package com.fernandez.basketball.euroleague.match.playersmatch.service;

import com.fernandez.basketball.euroleague.match.playersmatch.dto.PlayerMatch;

import java.io.IOException;

public interface PlayersMatchService {
    PlayerMatch[] findPlayersMatchByTeam(String fileName)  throws IOException;

    PlayerMatch[] findPlayersMatchByTeamWitouthSync(String gameCode, String seassonCode, String teamCode) throws IOException;
}
