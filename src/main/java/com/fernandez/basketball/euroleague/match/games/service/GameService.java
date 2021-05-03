package com.fernandez.basketball.euroleague.match.games.service;

import com.fernandez.basketball.euroleague.match.games.dto.GamesDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GameService {
    public List<String> findAllGamesByTeamAndYear(String clubode , String seasoncode);
    public Page<GamesDTO> findAllGames (final Pageable pageable);
}
