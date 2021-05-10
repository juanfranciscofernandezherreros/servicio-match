package com.fernandez.basketball.euroleague.match.games.service;

import com.fernandez.basketball.euroleague.match.games.dto.GamesDTO;
import com.fernandez.basketball.euroleague.match.games.dto.GamesScrappingDTO;
import com.fernandez.basketball.euroleague.match.playbyplay.dto.MatchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GameService {
    public MatchDTO save(MatchDTO matchDTO);
    public List<GamesScrappingDTO> findAllGamesByTeamAndYear(String clubode , String seasoncode);
    public Page<GamesDTO> findAllGames (final Pageable pageable);
}
