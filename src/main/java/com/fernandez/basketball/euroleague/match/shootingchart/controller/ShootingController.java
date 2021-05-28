package com.fernandez.basketball.euroleague.match.shootingchart.controller;

import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.shootingchart.dto.Shooting;
import com.fernandez.basketball.euroleague.match.shootingchart.service.ShootingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.SHOOTING)
    public Shooting findAllShootingWitouthSync(@RequestParam("gameCode") String gameCode , @RequestParam("seassonCode") String seassonCode) throws IOException {
        log.info("[ShootingController][findAllShootingWitouthSync] gameCode={} seassonCode={}" + gameCode,seassonCode);
        return shootingService.findAllShootingWitouthSync(gameCode,seassonCode);
    }
}

