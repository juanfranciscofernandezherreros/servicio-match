package com.fernandez.basketball.euroleague.match.header.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.header.dto.Header;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
@Service
@RequiredArgsConstructor
public class HeaderServiceImpl implements HeaderService{
    @Override
    public Header findHeader(String fileName) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        Header header = new ObjectMapper().readValue(new FileInputStream(UrlMapping.MAIN_RESOURCES+UrlMapping.HEADER+"/"+fileName+".json"), Header.class );
        return header;
    }

    @Override
    public ResponseEntity<Header> findInfoMatch(String gamecode, String seasoncode){
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        return rt.exchange("https://live.euroleague.net/api/Header?gamecode="+gamecode+"&seasoncode=E"+seasoncode, HttpMethod.GET, entity, Header.class);
    }


}
