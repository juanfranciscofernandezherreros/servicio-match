package com.fernandez.basketball.euroleague.match.points.controller;

import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.points.dto.Points;
import com.fernandez.basketball.euroleague.match.points.service.PointsService;
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
public class PointsController {

    private final PointsService pointsService;

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.POINTS + "/{fileName}")
    public Points findAllPointsFromMatchInJsonFile(@PathVariable String fileName) throws IOException {
        log.info("[PointsController][findAllPointsFromMatchInJsonFile] fileName={}" , fileName);
        return pointsService.findAllPointsFromMatchInJsonFile(fileName);
    }

}

