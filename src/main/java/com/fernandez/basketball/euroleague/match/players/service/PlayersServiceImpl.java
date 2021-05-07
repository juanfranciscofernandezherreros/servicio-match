package com.fernandez.basketball.euroleague.match.players.service;

import com.fernandez.basketball.euroleague.match.players.dto.PlayerDTO;
import com.fernandez.basketball.utils.DocumenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class PlayersServiceImpl implements PlayersService{

    @Override
    public List<PlayerDTO> findAllPlayersByTeamAndPosition(String letters, Pageable pageable) {
        String url = "https://www.euroleague.net/competition/players?listtype=alltime&name="+letters;
        Document document = DocumenUtils.getHtmlDocument(url);
        Elements links = document.select("a[href]");
        List<PlayerDTO> playerDTOList = new ArrayList<PlayerDTO>();
        for (Element link : links) {
            PlayerDTO playerDTO = new PlayerDTO();
            if(!link.text().isEmpty() && link.attr("href").contains("/competition/players/showplayer")) {
                System.out.println(link.text());
                playerDTO.setName(link.text());
                playerDTOList.add(playerDTO);
            }
        }
        return playerDTOList;
    }
}
