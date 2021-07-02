package com.fernandez.basketball.euroleague.players.statistics.controller;

import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.players.dto.PlayerDTO;
import com.fernandez.basketball.euroleague.players.statistics.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = UrlMapping.ROOT, produces = {APPLICATION_JSON_VALUE})
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping(value = UrlMapping.PUBLIC + UrlMapping.V1 + UrlMapping.LEADERS)
    public ResponseEntity<Page<PlayerDTO>> findLeaders (final @PageableDefault(size = 3000) Pageable pageable,
                                                        @RequestParam("pageNumber") Long pageNumber){
        log.info("[StatisticsController][findLeaders] pageable={} pageNumber={}",pageable,pageNumber);
        return ResponseEntity.ok(statisticsService.findLeaders(pageable,pageNumber));
    }

}
