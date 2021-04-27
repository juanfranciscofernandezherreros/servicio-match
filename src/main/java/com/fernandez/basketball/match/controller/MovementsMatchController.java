package com.fernandez.basketball.match.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandez.basketball.match.constants.UrlMapping;
import com.fernandez.basketball.match.dto.Match;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = UrlMapping.ROOT, produces = {APPLICATION_JSON_VALUE})
public class MovementsMatchController {

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.PLAYBYPLAY)
    public Match findAllMovementsMatch() throws IOException {
            final ObjectMapper objectMapper = new ObjectMapper();
            Match match = new ObjectMapper().readValue(new FileInputStream("src/main/resources/PlayByPlay.json"), Match.class );
            return match;
    }

}

