package com.fernandez.basketball.euroleague.match.players.controller;

import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.players.dto.PlayerDTO;
import com.fernandez.basketball.euroleague.match.players.service.PlayersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = UrlMapping.ROOT, produces = {APPLICATION_JSON_VALUE})
public class PlayersController {

    private final PlayersService playersService;

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.PLAYERS)
    public Page<PlayerDTO> findAllPlayersByTeamAndPosition(@RequestParam(required=true) String team,
                                                           @RequestParam(required=true) String letters,
                                                           Pageable pageable) {
        log.info("[PlayersController][findAllPlayersByTeamAndPosition] lettersPlayers={}",letters );
        return playersService.findAllPlayersByTeamAndPosition(team,letters , pageable);
    }

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.SHOWPLAYER)
    public PlayerDTO findPlayerByYear(
            @RequestParam(required=true) String pcode,
            @RequestParam(required=true) String seasoncode) {
        return playersService.findPlayerByYear(pcode,seasoncode);
    }





}
