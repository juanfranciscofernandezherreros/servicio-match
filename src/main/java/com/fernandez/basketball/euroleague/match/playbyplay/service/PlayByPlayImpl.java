package com.fernandez.basketball.euroleague.match.playbyplay.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.common.repository.*;
import com.fernandez.basketball.euroleague.match.playbyplay.adapter.MatchAdapter;
import com.fernandez.basketball.euroleague.match.playbyplay.dto.MarkAsFavouriteDTO;
import com.fernandez.basketball.euroleague.match.playbyplay.dto.MatchDTO;
import com.fernandez.basketball.euroleague.match.playbyplay.entity.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayByPlayImpl implements PlayByPlayService{

    private final RestTemplate appRestClient;

    private final ModelMapper modelMapper = new ModelMapper();

    private final MatchRepository matchRepository;

    private final FirstQuarterRepository firstQuarterRepository;

    private final SecondQuarterRepository secondQuarterRepository;

    private final ThirdQuarterRepository thirdQuarterRepository;

    private final ForthQuarterRepository forthQuarterRepository;

    private final ExtraTimeRepository extraTimeRepository;


    @Override
    public MatchDTO findAllMovementsFromMatchInJsonFile(String fileName) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        MatchDTO match = new ObjectMapper().readValue(new FileInputStream(UrlMapping.MAIN_RESOURCES+UrlMapping.PLAYBYPLAY+"/"+fileName+".json"), MatchDTO.class );
        return match;
    }

    @Override
    public Match save(MatchDTO saveMatch){
        Match match = MatchAdapter.mapToEntity(saveMatch);
        return matchRepository.save(match);
    }

    @Override
    public ResponseEntity<MatchDTO> download(String gamecode, String seasoncode) {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        return rt.exchange("https://live.euroleague.net/api/PlayByPlay?gamecode="+gamecode+"&seasoncode=E"+seasoncode+"", HttpMethod.GET, entity, MatchDTO.class);
    }

    @Override
    public MatchDTO findAllPlayByPlayFromMatch(Long matchId) {
        Match match = matchRepository.findById(matchId).get();
        return modelMapper.map(match,MatchDTO.class);
    }

    @Override
    public void markAsFavourite(MarkAsFavouriteDTO markAsFavouriteDTO) {
        if(Objects.nonNull(markAsFavouriteDTO.getFirstQuarterDTO())){
            FirstQuarter firstQuarter = firstQuarterRepository.getOne(markAsFavouriteDTO.getFirstQuarterDTO().getId());
            firstQuarter.setMarkAsFavourite(true);
            firstQuarterRepository.save(firstQuarter);
        }
        if(Objects.nonNull(markAsFavouriteDTO.getSecondQuarterDTO())){
            SecondQuarter secondQuarter = secondQuarterRepository.getOne(markAsFavouriteDTO.getSecondQuarterDTO().getId());
            secondQuarter.setMarkAsFavourite(true);
            secondQuarterRepository.save(secondQuarter);
        }
        if(Objects.nonNull(markAsFavouriteDTO.getThirdQuarterDTO())){
            ThirdQuarter thirdQuarter = thirdQuarterRepository.getOne(markAsFavouriteDTO.getThirdQuarterDTO().getId());
            thirdQuarter.setMarkAsFavourite(true);
            thirdQuarterRepository.save(thirdQuarter);
        }
        if(Objects.nonNull(markAsFavouriteDTO.getFirstQuarterDTO())){
            ForthQuarter forthQuarter = forthQuarterRepository.getOne(markAsFavouriteDTO.getForthQuarterDTO().getId());
            forthQuarter.setMarkAsFavourite(true);
            forthQuarterRepository.save(forthQuarter);
        }
        if(Objects.nonNull(markAsFavouriteDTO.getExtraTimeDTO())){
            ExtraTime extraTime = extraTimeRepository.getOne(markAsFavouriteDTO.getExtraTimeDTO().getId());
            extraTime.setMarkAsFavourite(true);
            extraTimeRepository.save(extraTime);
        }
    }
}
