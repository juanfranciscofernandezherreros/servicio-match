package com.fernandez.basketball.euroleague.match.header.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandez.basketball.commons.constants.UrlMapping;
import com.fernandez.basketball.euroleague.match.header.dto.Header;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public Header headerWitouthSync(String gameCode,String seassonCode) throws IOException {
        URL url = new URL("https://live.euroleague.net/api/Header?gamecode="+gameCode+"&seasoncode=E"+seassonCode);
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
        Header headerDTO = mapper.readValue(in, Header.class);
        return  headerDTO;
    }


}
