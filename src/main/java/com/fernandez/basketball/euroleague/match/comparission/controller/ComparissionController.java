package com.fernandez.basketball.euroleague.match.comparission.controller;

import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.comparission.dto.Comparission;
import com.fernandez.basketball.euroleague.match.comparission.service.ComparissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = UrlMapping.ROOT, produces = {APPLICATION_JSON_VALUE})
public class ComparissionController {

    private final ComparissionService comparissionService;

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.COMPARISSION + "/{fileName}")
    public Comparission findComparisionFromJson(@PathVariable String fileName) throws IOException {
        log.info("[ComparissionController][findComparisionFromJson] fileName={}" , fileName);
        return comparissionService.findComparisionFromJson(fileName);
    }

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.COMPARISSION)
    public Comparission comparisionWitouthSync(@RequestParam("gameCode") String gameCode , @RequestParam("seassonCode") String seassonCode) throws IOException {
        log.info("[ComparissionController][comparisionWitouthSync] gameCode={} seassonCode={}" + gameCode,seassonCode);
        return comparissionService.comparisionWitouthSync(gameCode,seassonCode);
    }

}
