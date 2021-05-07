package com.fernandez.basketball.euroleague.match.players.controller;

import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.players.dto.PlayerDTO;
import com.fernandez.basketball.euroleague.match.players.service.PlayersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = UrlMapping.ROOT, produces = {APPLICATION_JSON_VALUE})
public class PlayersController {

    private final PlayersService playersService;

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.PLAYERS)
    public Page<PlayerDTO> findAllPlayersByTeamAndPosition(@RequestParam(required=true) String letters,
                                                           Pageable pageable) {
        log.info("[PlayersController][findAllPlayersByTeamAndPosition] lettersPlayers={}",letters );
        return playersService.findAllPlayersByTeamAndPosition(letters , pageable);
    }



}
