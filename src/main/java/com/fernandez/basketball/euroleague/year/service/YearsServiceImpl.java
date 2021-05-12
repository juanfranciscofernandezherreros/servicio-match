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

@Slf4j
@Service
@RequiredArgsConstructor
public class YearsServiceImpl implements YearService{
    @Override
    public List<String> findAll() {
        List<String> yearsList = new ArrayList<>();
        String url = "https://www.euroleague.net/main/standings";
        Document document = DocumenUtils.getHtmlDocument(url);
        Element div = document.select("div.styled-select:nth-child(1) > select:nth-child(1)").first();
        Elements elements = div.children();
        for (Element element : elements) {
            yearsList.add(element.text().substring(0,4));
        }
        return yearsList;
    }
}
