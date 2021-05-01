package com.fernandez.basketball.euroleague.match.shootingChart.controller;

import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.playByPlay.dto.Match;
import com.fernandez.basketball.euroleague.match.playByPlay.service.PlayByPlayService;
import com.fernandez.basketball.euroleague.match.shootingChart.dto.Shooting;
import com.fernandez.basketball.euroleague.match.shootingChart.service.ShootingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = UrlMapping.ROOT, produces = {APPLICATION_JSON_VALUE})
public class ShootingController {

    private final ShootingService shootingService;

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.SHOOTING + "/{fileName}")
    public Shooting findAll(@PathVariable String fileName) throws IOException {
        log.info("[ShootingController][findAll] fileName={}" , fileName);
        return shootingService.findAllShootingFromMatchInJsonFile(fileName);
    }

}

