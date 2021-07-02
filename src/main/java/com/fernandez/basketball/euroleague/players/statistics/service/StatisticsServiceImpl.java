package com.fernandez.basketball.euroleague.players.statistics.service;

import com.fernandez.basketball.euroleague.players.dto.PlayerDTO;
import com.fernandez.basketball.utils.DocumenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Page<PlayerDTO> findLeaders(Pageable pageable,Long pageNumber) {
        String url = "https://www.euroleague.net/main/statistics?mode=Leaders&entity=Players&seasonmode=Range&fromseasoncode=E2020&toseasoncode=E2020&cat=Valuation&agg=Accumulated&page="+pageNumber;
        Document document = DocumenUtils.getHtmlDocument(url);
        Elements links = document.select("a[href]");
        List<PlayerDTO> statisticsPlayerDTOList = new ArrayList<PlayerDTO>();
        List<String> namesList = new ArrayList<>();
        List<String> playersList = new ArrayList<>();
        List<String> teamCodeList = new ArrayList<>();
        for (Element link : links) {
            if (!link.text().isEmpty()) {
                PlayerDTO playerDTO = new PlayerDTO();
                if (link.attr("href").contains("/competition/players/showplayer")) {
                    namesList.add(link.text());
                    playersList.add(link.attr("href").split("&")[0].split("=")[1]);
                }
                if (link.attr("href").contains("/competition/teams/showteam")) {
                    teamCodeList.add(link.attr("href").split("&")[0].split("=")[1]);
                }
            }
        }

        for (int i = 0; i < playersList.size(); i++) {
            PlayerDTO playerDTO = new PlayerDTO();
            playerDTO.setPlayerCode(playersList.get(i));
            playerDTO.setName(namesList.get(i));
            playerDTO.setNameTeam(teamCodeList.get(i));
            mongoTemplate.save(playerDTO);
            statisticsPlayerDTOList.add(playerDTO);

        }
        return convertList2Page(statisticsPlayerDTOList,pageable);
    }

    private Page convertList2Page(final List list, final Pageable pageable) {
        return getPage(list, pageable);
    }

    @NotNull
    static Page getPage(final List list, final Pageable pageable) {
        int startIndex = (int) pageable.getOffset();
        int endIndex = (int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size()
                : pageable.getOffset() + pageable.getPageSize());
        List subList = list.subList(startIndex, endIndex);
        return new PageImpl(subList, pageable, list.size());
    }
}
