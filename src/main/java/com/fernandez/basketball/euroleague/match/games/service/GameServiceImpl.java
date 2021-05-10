package com.fernandez.basketball.euroleague.match.games.service;

import com.fernandez.basketball.euroleague.match.common.repository.MatchRepository;
import com.fernandez.basketball.euroleague.match.games.dto.GamesDTO;
import com.fernandez.basketball.euroleague.match.games.dto.GamesScrappingDTO;
import com.fernandez.basketball.euroleague.match.playbyplay.adapter.MatchAdapter;
import com.fernandez.basketball.euroleague.match.playbyplay.dto.MatchDTO;
import com.fernandez.basketball.euroleague.match.playbyplay.entity.Match;
import com.fernandez.basketball.utils.DocumenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService{

    private final MatchRepository matchRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public MatchDTO save(MatchDTO matchDTO) {
        Match match = MatchAdapter.mapToEntity(matchDTO);
        return modelMapper.map(matchRepository.save(match),MatchDTO.class);
    }

    @Override
    public List<GamesScrappingDTO> findAllGamesByTeamAndYear(String clubcode, String seasoncode) {
        String url = "https://www.euroleague.net/competition/teams/showteam?clubcode="+clubcode+"&seasoncode=E"+seasoncode+"#!games";
        List<GamesScrappingDTO> gamesScrappingDTOList = new ArrayList<>();
        // Compruebo si me da un 200 al hacer la petición
        if (DocumenUtils.getStatusConnectionCode(url) == 200) {
            // Obtengo el HTML de la web en un objeto Document
            Document document = DocumenUtils.getHtmlDocument(url);
            Elements versusContainer = document.select("td.VersusContainer");
            Elements gameNumberContainer = document.select("td.GameNumberContainer");
            Elements winLoseContainer = document.select("td.WinLoseContainer");
            Elements teamPhaseGameScoreContainer = document.select("td.TeamPhaseGameScoreContainer");
            Elements linksMatchContainer = versusContainer.select("a[href]");
            List<String> gameNumberList = new ArrayList<>();
            List<String> winLoseList = new ArrayList<>();
            List<String> versusList = new ArrayList<>();
            List<String> teamPhaseGameScoreList = new ArrayList<>();
            List<String> linksMatchList = new ArrayList<>();

            for (Element number : gameNumberContainer) {
                gameNumberList.add(number.text());
            }
            for (Element winLose : winLoseContainer) {
                winLoseList.add(winLose.text());
            }
            for (Element versus : versusContainer) {
                versusList.add(versus.text());
            }
            for (Element teamPhaseGameScore : teamPhaseGameScoreContainer) {
                teamPhaseGameScoreList.add(teamPhaseGameScore.text());
            }
            for (Element linkMatch : linksMatchContainer) {
                linksMatchList.add("https://www.euroleague.net".concat(linkMatch.attr("href")));
            }
            for(int i=0;i<gameNumberList.size();i++){
                GamesScrappingDTO gamesScrappingDTO = new GamesScrappingDTO();
                gamesScrappingDTO.setNumberMatch(gameNumberList.get(i));
                gamesScrappingDTO.setWinLose(winLoseList.get(i));
                gamesScrappingDTO.setVersus(versusList.get(i));
                gamesScrappingDTO.setTeamPhaseGameScore(teamPhaseGameScoreList.get(i));
                gamesScrappingDTO.setMatchLink(linksMatchList.get(i));
                gamesScrappingDTOList.add(gamesScrappingDTO);
            }
        }else{
            log.error("El Status Code no es OK es: "+DocumenUtils.getStatusConnectionCode(url));
        }
        return gamesScrappingDTOList;
    }

    @Override
    public Page<GamesDTO> findAllGames (final Pageable pageable ) {
        return matchRepository.findAll(pageable).map(this::mapFromEntityToDto);
    }

    private GamesDTO mapFromEntityToDto (final Match match ) {
        return modelMapper.map(match, GamesDTO.class);
    }

}
