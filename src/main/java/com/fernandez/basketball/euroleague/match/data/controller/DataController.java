package com.fernandez.basketball.euroleague.match.data.controller;

import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.data.dto.DataDTO;
import com.fernandez.basketball.euroleague.match.data.service.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = UrlMapping.ROOT, produces = {APPLICATION_JSON_VALUE})
public class DataController {

    private final DataService dataService;

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.PLAYBYPLAY + UrlMapping.DATA)
    public ResponseEntity<DataDTO> findDataMatch(@RequestParam String gamecode ,
                                                 @RequestParam String seasoncode) throws IOException {
        log.info("[DataController][findDataMatch] gamecode={} seasoncode={}",gamecode,seasoncode);
        return ResponseEntity.ok(dataService.findCompleteDataMtach(gamecode, seasoncode));
    }

}
