package com.fernandez.basketball.euroleague.match.playbyplay.controller;

import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.playbyplay.dto.Match;
import com.fernandez.basketball.euroleague.match.playbyplay.service.PlayByPlayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.Arrays;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = UrlMapping.ROOT, produces = {APPLICATION_JSON_VALUE})
public class PlayByPlayController {

    private final PlayByPlayService playByPlayService;

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.PLAYBYPLAY + "/{fileName}")
    public Match findAll(@PathVariable String fileName) throws IOException {
        log.info("[PlayByPlayController][findAll] fileName={}" , fileName);
        return playByPlayService.findAllMovementsFromMatchInJsonFile(fileName);
    }

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.PLAYBYPLAY + "/{gamecode}"+ UrlMapping.DOWNLOAD + "/{seasoncode}")
    public  ResponseEntity<Match> downloadPlayByPlay(@PathVariable String gamecode , @PathVariable String seasoncode) throws IOException {
        log.info("[PlayByPlayController][downloadPlayByPlay]");
        return playByPlayService.download(gamecode,seasoncode);
    }

}

