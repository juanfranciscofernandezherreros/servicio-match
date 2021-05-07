package com.fernandez.basketball.euroleague.match.players.service;

import com.fernandez.basketball.euroleague.match.players.dto.PlayerDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlayersService {
    List<PlayerDTO> findAllPlayersByTeamAndPosition(String letters, Pageable pageable);
}
