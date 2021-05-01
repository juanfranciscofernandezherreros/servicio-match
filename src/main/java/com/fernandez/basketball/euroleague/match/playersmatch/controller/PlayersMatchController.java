package com.fernandez.basketball.euroleague.match.playersmatch.controller;

import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.playersmatch.dto.PlayerMatch;
import com.fernandez.basketball.euroleague.match.playersmatch.service.PlayersMatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = UrlMapping.ROOT, produces = {APPLICATION_JSON_VALUE})
public class PlayersMatchController {

    private final PlayersMatchService playersMatchService;

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.PLAYERSMATCH + "/{fileName}")
    public PlayerMatch[] findPlayersMatchByTeam(@PathVariable String fileName) throws IOException {
        log.info("[PlayersMatchController][findPlayersMatchByTeam] fileName={}" , fileName);
        return playersMatchService.findPlayersMatchByTeam(fileName);
    }

}
