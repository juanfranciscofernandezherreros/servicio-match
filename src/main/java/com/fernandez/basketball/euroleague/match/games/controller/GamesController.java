package com.fernandez.basketball.euroleague.match.games.controller;

import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.games.dto.GamesDTO;
import com.fernandez.basketball.euroleague.match.games.dto.GamesScrappingDTO;
import com.fernandez.basketball.euroleague.match.games.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = UrlMapping.ROOT, produces = {APPLICATION_JSON_VALUE})
public class GamesController {

    private final GameService gameService;

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.GAMES + UrlMapping.CLUBCODE + "/{clubcode}" + UrlMapping.SEASSONCODE + "/{seasoncode}")
    public List<GamesScrappingDTO> findAllGamesByTeamAndYear(@PathVariable String clubcode , @PathVariable String seasoncode) {
        log.info("[GamesController][findAllGamesByTeamAndYear] clubcode={} seasoncode={}" , clubcode , seasoncode);
        return gameService.findAllGamesByTeamAndYear(clubcode,seasoncode);
    }

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.GAMES)
    public Page<GamesDTO> findAllGames(final Pageable pageable) {
        log.info("[GamesController][findAllGames]");
        return gameService.findAllGames(pageable);
    }

}
