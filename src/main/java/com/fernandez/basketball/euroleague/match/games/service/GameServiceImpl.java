package com.fernandez.basketball.euroleague.match.games.service;

import com.fernandez.basketball.utils.DocumenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService{

    @Override
    public List<String> findAllGamesByTeamAndYear(String clubcode, String seasoncode) {
        String url = "https://www.euroleague.net/competition/teams/showteam?clubcode="+clubcode+"&seasoncode=E"+seasoncode+"#!games";
        List<String> gamesDTOList = new ArrayList<>();
        // Compruebo si me da un 200 al hacer la petición
        if (DocumenUtils.getStatusConnectionCode(url) == 200) {
            // Obtengo el HTML de la web en un objeto Document
            Document document = DocumenUtils.getHtmlDocument(url);
            Elements links = document.select("a[href]");
            for (Element link : links) {
                if(link.text().contains("vs") && link.attr("href").contains("/main/results/showgame")){
                    gamesDTOList.add("https://www.euroleague.net".concat(link.attr("href")));
                }
            }
        }else{
            log.error("El Status Code no es OK es: "+DocumenUtils.getStatusConnectionCode(url));
        }
        return gamesDTOList;
    }

}
