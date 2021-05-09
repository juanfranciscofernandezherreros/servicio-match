package com.fernandez.basketball.euroleague.match.playbyplay.controller;

import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.playbyplay.dto.MarkAsFavouriteDTO;
import com.fernandez.basketball.euroleague.match.playbyplay.dto.MatchDTO;
import com.fernandez.basketball.euroleague.match.playbyplay.entity.Match;
import com.fernandez.basketball.euroleague.match.playbyplay.service.PlayByPlayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = UrlMapping.ROOT, produces = {APPLICATION_JSON_VALUE})
public class PlayByPlayController {

    private final PlayByPlayService playByPlayService;

    @PostMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.PLAYBYPLAY)
    public Match save(@RequestBody MatchDTO match) {
        log.info("[PlayByPlayController][save] match={}" , match);
        return playByPlayService.save(match);
    }

    @PostMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.FAVOURITE + UrlMapping.PLAYBYPLAY)
    public void markPlayByPlayAsFavourite(@RequestBody MarkAsFavouriteDTO markAsFavouriteDTO) {
        log.info("[PlayByPlayController][markPlayByPlayAsFavourite] markAsFavouriteDTO={}" , markAsFavouriteDTO);
        playByPlayService.markAsFavourite(markAsFavouriteDTO);
    }

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.PLAYBYPLAY + "/{fileName}")
    public MatchDTO findAll(@PathVariable String fileName) throws IOException {
        log.info("[PlayByPlayController][findAll] fileName={}" , fileName);
        return playByPlayService.findAllMovementsFromMatchInJsonFile(fileName);
    }

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.MATCH + "/{matchId}")
    public MatchDTO findAllPlayByPlayFromMatch(@PathVariable Long matchId) {
        log.info("[PlayByPlayController][findAllPlayByPlayFromMatch] matchId={}" , matchId);
        return playByPlayService.findAllPlayByPlayFromMatch(matchId);
    }

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.PLAYBYPLAY + "/{gamecode}"+ UrlMapping.DOWNLOAD + "/{seasoncode}")
    public  ResponseEntity<MatchDTO> downloadPlayByPlay(@PathVariable String gamecode , @PathVariable String seasoncode) {
        log.info("[PlayByPlayController][downloadPlayByPlay]");
        return playByPlayService.download(gamecode,seasoncode);
    }

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.SYNC + UrlMapping.PLAYBYPLAY + "/{gamecode}"+ UrlMapping.DOWNLOAD + "/{seasoncode}")
    public Match syncWithDatabase(@PathVariable String gamecode , @PathVariable String seasoncode) {
        log.info("[PlayByPlayController][downloadPlayByPlay]");
        ResponseEntity<MatchDTO> matchDTO = playByPlayService.download(gamecode,seasoncode);
        return playByPlayService.save(matchDTO.getBody());
    }

}

