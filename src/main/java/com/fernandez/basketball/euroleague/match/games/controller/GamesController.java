package com.fernandez.basketball.euroleague.match.games.controller;

import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.games.dto.GamesDTO;
import com.fernandez.basketball.euroleague.match.games.dto.GamesScrappingDTO;
import com.fernandez.basketball.euroleague.match.games.service.GameService;
import com.fernandez.basketball.euroleague.match.playbyplay.dto.MatchDTO;
import com.fernandez.basketball.euroleague.match.playbyplay.service.PlayByPlayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = UrlMapping.ROOT, produces = {APPLICATION_JSON_VALUE})
public class GamesController {

    private final GameService gameService;

    private final PlayByPlayService playByPlayService;


    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 +UrlMapping.SYNC + UrlMapping.GAMES + UrlMapping.CLUBCODE + "/{clubcode}" + UrlMapping.SEASSONCODE + "/{seasoncode}")
    public Page<GamesScrappingDTO> syncAllGamesByTeamAndYear(@PathVariable String clubcode ,
                                                             @PathVariable String seasoncode ,
                                                             final @PageableDefault(size = 3000) Pageable pageable) throws MalformedURLException, UnsupportedEncodingException {
        log.info("[GamesController][syncAllGamesByTeamAndYear] clubcode={} seasoncode={}" , clubcode , seasoncode);

        return gameService.findAllGamesByTeamAndYear(clubcode,seasoncode,pageable);
    }


    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.GAMES + UrlMapping.CLUBCODE + "/{clubcode}" + UrlMapping.SEASSONCODE + "/{seasoncode}")
    public Page<GamesScrappingDTO> findAllBySeassonCodeAndHeader(@PathVariable String clubcode ,
                                                                 @PathVariable String seasoncode ,
                                                                 final @PageableDefault(size = 3000) Pageable pageable) throws MalformedURLException, UnsupportedEncodingException {
        log.info("[GamesController][findAllBySeassonCodeAndHeader] seasoncode={} clubcode={}", seasoncode ,clubcode);
        return gameService.findAllGamesTeamAndYear(seasoncode,clubcode,pageable);
    }

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.GAMES)
    public Page<GamesDTO> findAllGames(final Pageable pageable) {
        log.info("[GamesController][findAllGames]");
        return gameService.findAllGames(pageable);
    }

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.MATCH + "/{matchId}")
    public MatchDTO findAllPlayByPlayFromMatch(@PathVariable Long matchId) {
        log.info("[PlayByPlayController][findAllPlayByPlayFromMatch] matchId={}" , matchId);
        return playByPlayService.findAllPlayByPlayFromMatch(matchId);
    }

}
