package com.fernandez.basketball.euroleague.match.comparission.service;

import com.fernandez.basketball.euroleague.match.comparission.dto.Comparission;

import java.io.IOException;

public interface ComparissionService {
    Comparission findComparisionFromJson(String fileName) throws IOException;

    Comparission comparisionWitouthSync(String gameCode, String seassonCode) throws IOException;
}
