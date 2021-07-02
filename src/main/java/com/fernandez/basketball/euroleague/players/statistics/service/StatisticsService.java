package com.fernandez.basketball.euroleague.players.statistics.service;

import com.fernandez.basketball.euroleague.players.dto.PlayerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StatisticsService {
    public Page<PlayerDTO> findLeaders(Pageable pageable,Long pageNumber);
}
