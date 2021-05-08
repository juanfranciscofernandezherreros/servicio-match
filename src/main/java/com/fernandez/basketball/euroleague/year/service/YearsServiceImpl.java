package com.fernandez.basketball.euroleague.year.service;

import com.fernandez.basketball.utils.DocumenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class YearsServiceImpl implements YearService{
    @Override
    public List<String> findAll() {
        List<String> yearsList = new ArrayList<>();
        String url = "https://www.euroleague.net/competition/teams";
        Document document = DocumenUtils.getHtmlDocument(url);
        Elements divs = document.select(".seasons-selector");
        for (Element div : divs){
            for(Element child : div.children()){
                yearsList.add(child.text().substring(11,15));
            }
        }
        return yearsList;
    }
}
