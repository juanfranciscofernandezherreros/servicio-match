package com.fernandez.basketball.euroleague.match.playbyplay.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.common.repository.*;
import com.fernandez.basketball.euroleague.match.playbyplay.adapter.MatchAdapter;
import com.fernandez.basketball.euroleague.match.playbyplay.dto.*;
import com.fernandez.basketball.euroleague.match.playbyplay.entity.jpa.Match;
import com.fernandez.basketball.euroleague.match.playbyplay.entity.jpa.Quarter;
import com.fernandez.basketball.euroleague.match.playbyplay.repository.MatchMongoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayByPlayImpl implements PlayByPlayService{

    private final RestTemplate appRestClient;

    private final ModelMapper modelMapper = new ModelMapper();

    private final MatchRepository matchRepository;

    private final FirstQuarterRepository firstQuarterRepository;

    private final MatchMongoRepository matchMongoRepository;

    @Override
    public MatchDTO findAllMovementsFromMatchInJsonFile(String fileName) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        MatchDTO match = new ObjectMapper().readValue(new FileInputStream(UrlMapping.MAIN_RESOURCES+UrlMapping.PLAYBYPLAY+"/"+fileName+".json"), MatchDTO.class );
        return match;
    }

        @Override
        public ResponseEntity<MatchDTO> download(String gamecode, String seasoncode) throws IOException {
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
    public MatchDTO save(MatchDTO saveMatch){
        Match match = MatchAdapter.mapToEntity(saveMatch);
        return modelMapper.map(matchRepository.save(match),MatchDTO.class);
    }

    @Override
    public ResponseEntity<MatchDTO> downloadWitouthSync(String gamecode, String seasoncode) throws IOException {
        URL url = new URL("https://live.euroleague.net/api/PlayByPlay?gamecode="+gamecode+"&seasoncode=E"+seasoncode+"&disp=");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestProperty("authority", "live.euroleague.net");
        http.setRequestProperty("accept", "application/json, text/plain, */*");
        http.setRequestProperty("dnt", "1");
        http.setRequestProperty("sec-ch-ua-mobile", "?0");
        http.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36");
        http.setRequestProperty("sec-fetch-site", "same-origin");
        http.setRequestProperty("sec-fetch-mode", "cors");
        http.setRequestProperty("sec-fetch-dest", "empty");
        ObjectMapper mapper=new ObjectMapper();
        BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
        MatchDTO matchDTO = mapper.readValue(in, MatchDTO.class);
        return  ResponseEntity.ok(matchDTO);
    }

    @Override
    public void deleteByMarkAsFavourite(String numberOfPlay,String gamecode, String seasoncode) {
       Quarter firtsQuarter = firstQuarterRepository.findBygamecodeAndSeassoncodeAndNumberofplay(gamecode,seasoncode,Integer.valueOf(numberOfPlay));
       firstQuarterRepository.deleteById(firtsQuarter.getId());
    }

    @Override
    public MarkAsFavouriteDTO markAsFavourite(MarkAsFavouriteDTO markAsFavouriteDTO) {
        MarkAsFavouriteDTO markAsFavouriteDTOCreated = new MarkAsFavouriteDTO();
        Match match = null;
        Optional<Match> optionalMatch = matchRepository.findByGameCodeAndSeassonCode(markAsFavouriteDTO.getGameCode(),markAsFavouriteDTO.getSeassonCode());
        if (optionalMatch.isPresent()){
            match = optionalMatch.get();
        }else{
            Match newMatch = new Match();
            newMatch.setGameCode(markAsFavouriteDTO.getGameCode());
            newMatch.setSeassonCode(markAsFavouriteDTO.getSeassonCode());
            match = matchRepository.save(newMatch);
        }
            Quarter firstQuarter = null;
            FirstQuarterDTO firstQuarterDTO = markAsFavouriteDTO.getQuarterDTo();
            if (Objects.nonNull(firstQuarterDTO.getId())) {
                firstQuarter = firstQuarterRepository.getOne(firstQuarterDTO.getId());
            } else {
                firstQuarter = modelMapper.map(firstQuarterDTO, Quarter.class);
            }
            firstQuarter.setActualQuarter(markAsFavouriteDTO.getActualQuarter());
            firstQuarter.setMarkAsFavourite(markAsFavouriteDTO.getQuarterDTo().isMarkAsFavourite());
            firstQuarter.setGamecode(markAsFavouriteDTO.getGameCode());
            firstQuarter.setSeassoncode(markAsFavouriteDTO.getSeassonCode());
            firstQuarter.setMatch(match);
            Quarter frstQuarter = firstQuarterRepository.save(firstQuarter);
            if(markAsFavouriteDTO.getActualQuarter().equals("1")){
                System.out.println("MatchMongo:"+matchMongoRepository.findAll());
            }
            if(markAsFavouriteDTO.getActualQuarter().equals("2")){
            }
            if(markAsFavouriteDTO.getActualQuarter().equals("3")){
            }
            if(markAsFavouriteDTO.getActualQuarter().equals("4")){
            }
            markAsFavouriteDTOCreated.setQuarterDTo(modelMapper.map(frstQuarter, FirstQuarterDTO.class));
        return markAsFavouriteDTOCreated;
    }
}
