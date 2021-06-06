package com.fernandez.basketball.euroleague.match.data.dto;

import com.fernandez.basketball.euroleague.match.boxscore.dto.BoxScore;
import com.fernandez.basketball.euroleague.match.comparission.dto.Comparission;
import com.fernandez.basketball.euroleague.match.evolution.dto.Evolution;
import com.fernandez.basketball.euroleague.match.header.dto.Header;
import com.fernandez.basketball.euroleague.match.playbyplay.dto.MatchDTO;
import com.fernandez.basketball.euroleague.match.playersmatch.dto.PlayerMatch;
import com.fernandez.basketball.euroleague.match.points.dto.Points;
import com.fernandez.basketball.euroleague.match.shootingchart.dto.Shooting;

import java.util.Arrays;


public class DataDTO {
    String _id;
    Header header;
    MatchDTO matchDTO;
    PlayerMatch[] playerMatchTeamA;
    PlayerMatch[] playerMatchTeamB;
    BoxScore boxScore;
    Points points;
    Evolution evolution;
    Comparission comparission;
    Shooting shooting;
    String gameCode;
    String seassonCode;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public MatchDTO getMatchDTO() {
        return matchDTO;
    }

    public void setMatchDTO(MatchDTO matchDTO) {
        this.matchDTO = matchDTO;
    }

    public PlayerMatch[] getPlayerMatchTeamA() {
        return playerMatchTeamA;
    }

    public void setPlayerMatchTeamA(PlayerMatch[] playerMatchTeamA) {
        this.playerMatchTeamA = playerMatchTeamA;
    }

    public PlayerMatch[] getPlayerMatchTeamB() {
        return playerMatchTeamB;
    }

    public void setPlayerMatchTeamB(PlayerMatch[] playerMatchTeamB) {
        this.playerMatchTeamB = playerMatchTeamB;
    }

    public BoxScore getBoxScore() {
        return boxScore;
    }

    public void setBoxScore(BoxScore boxScore) {
        this.boxScore = boxScore;
    }

    public Points getPoints() {
        return points;
    }

    public void setPoints(Points points) {
        this.points = points;
    }

    public Evolution getEvolution() {
        return evolution;
    }

    public void setEvolution(Evolution evolution) {
        this.evolution = evolution;
    }

    public Comparission getComparission() {
        return comparission;
    }

    public void setComparission(Comparission comparission) {
        this.comparission = comparission;
    }

    public Shooting getShooting() {
        return shooting;
    }

    public void setShooting(Shooting shooting) {
        this.shooting = shooting;
    }

    public String getGameCode() {
        return gameCode;
    }

    public void setGameCode(String gameCode) {
        this.gameCode = gameCode;
    }

    public String getSeassonCode() {
        return seassonCode;
    }

    public void setSeassonCode(String seassonCode) {
        this.seassonCode = seassonCode;
    }

    @Override
    public String toString() {
        return "DataDTO{" +
                "_id='" + _id + '\'' +
                ", header=" + header +
                ", matchDTO=" + matchDTO +
                ", playerMatchTeamA=" + Arrays.toString(playerMatchTeamA) +
                ", playerMatchTeamB=" + Arrays.toString(playerMatchTeamB) +
                ", boxScore=" + boxScore +
                ", points=" + points +
                ", evolution=" + evolution +
                ", comparission=" + comparission +
                ", shooting=" + shooting +
                ", gameCode='" + gameCode + '\'' +
                ", seassonCode='" + seassonCode + '\'' +
                '}';
    }
}
