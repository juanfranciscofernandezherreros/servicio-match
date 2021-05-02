package com.fernandez.basketball.euroleague.match.games.service;

import java.util.List;

public interface GameService {
    public List<String> findAllGamesByTeamAndYear(String clubode , String seasoncode);
}
