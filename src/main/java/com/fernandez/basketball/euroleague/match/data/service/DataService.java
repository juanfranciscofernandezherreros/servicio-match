package com.fernandez.basketball.euroleague.match.data.service;

import com.fernandez.basketball.euroleague.match.data.dto.DataDTO;

import java.io.IOException;

public interface DataService {
    DataDTO findCompleteDataMtach(String gameCode,String seassonCode) throws IOException;
}
