package com.fernandez.basketball.euroleague.match.players.service;

import com.fernandez.basketball.euroleague.match.players.dto.PlayerDTO;
import com.fernandez.basketball.utils.DocumenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Slf4j
@Service
@RequiredArgsConstructor
public class PlayersServiceImpl implements PlayersService{

    @Override
    public Page<PlayerDTO> findAllPlayersByTeamAndPosition(String letters, Pageable pageable) {
        String url = "https://www.euroleague.net/competition/players?listtype=alltime&name="+letters;
        Document document = DocumenUtils.getHtmlDocument(url);
        Elements links = document.select("a[href]");
        List<PlayerDTO> playerDTOList = new ArrayList<PlayerDTO>();
        for (Element link : links) {
            PlayerDTO playerDTO = new PlayerDTO();
            if(!link.text().isEmpty() && link.attr("href").contains("/competition/players/showplayer")) {
                String newUrlPlayer = "https://www.euroleague.net".concat(link.attr("href"));
                playerDTO.setName(link.text().toUpperCase());
                playerDTO.setLinkDetail(newUrlPlayer);
                playerDTOList.add(playerDTO);
            }
        }
        return convertList2Page(playerDTOList,pageable);
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
