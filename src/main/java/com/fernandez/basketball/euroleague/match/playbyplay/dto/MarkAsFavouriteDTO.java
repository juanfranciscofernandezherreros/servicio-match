package com.fernandez.basketball.euroleague.match.playbyplay.dto;

public class MarkAsFavouriteDTO {

    private FirstQuarterDTO quarterDTo;
    private String gameCode;
    private String seassonCode;
    private String actualQuarter;

    public FirstQuarterDTO getQuarterDTo() {
        return quarterDTo;
    }

    public void setQuarterDTo(FirstQuarterDTO quarterDTo) {
        this.quarterDTo = quarterDTo;
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

    public String getActualQuarter() {
        return actualQuarter;
    }

    public void setActualQuarter(String actualQuarter) {
        this.actualQuarter = actualQuarter;
    }

    @Override
    public String toString() {
        return "MarkAsFavouriteDTO{" +
                "quarterDTo=" + quarterDTo +
                ", gameCode='" + gameCode + '\'' +
                ", seassonCode='" + seassonCode + '\'' +
                ", actualQuarter='" + actualQuarter + '\'' +
                '}';
    }
}
