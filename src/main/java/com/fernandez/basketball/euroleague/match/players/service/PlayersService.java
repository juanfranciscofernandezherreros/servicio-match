package com.fernandez.basketball.euroleague.match.players.service;

import com.fernandez.basketball.euroleague.match.players.dto.PlayerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PlayersService {
    Page<PlayerDTO> findAllPlayersByTeamAndPosition(String team, String letters, Pageable pageable);
    PlayerDTO findPlayerByYear(String pCode,String year);
}
