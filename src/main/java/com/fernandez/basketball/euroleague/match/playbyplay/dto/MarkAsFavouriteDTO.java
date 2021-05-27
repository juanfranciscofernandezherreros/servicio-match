package com.fernandez.basketball.euroleague.match.playbyplay.dto;


import com.fernandez.basketball.euroleague.match.header.dto.Header;

public class MarkAsFavouriteDTO {
    private Long matchId;
    private Header headerDTO;
    private MatchDTO matchDTO;
    private FirstQuarterDTO firstQuarterDTO;
    private SecondQuarterDTO secondQuarterDTO;
    private ThirdQuarterDTO thirdQuarterDTO;
    private ForthQuarterDTO forthQuarterDTO;
    private ExtraTimeDTO extraTimeDTO;
    private String gameCode;
    private String seassonCode;

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Header getHeaderDTO() {
        return headerDTO;
    }

    public void setHeaderDTO(Header headerDTO) {
        this.headerDTO = headerDTO;
    }

    public MatchDTO getMatchDTO() {
        return matchDTO;
    }

    public void setMatchDTO(MatchDTO matchDTO) {
        this.matchDTO = matchDTO;
    }

    public FirstQuarterDTO getFirstQuarterDTO() {
        return firstQuarterDTO;
    }

    public void setFirstQuarterDTO(FirstQuarterDTO firstQuarterDTO) {
        this.firstQuarterDTO = firstQuarterDTO;
    }

    public SecondQuarterDTO getSecondQuarterDTO() {
        return secondQuarterDTO;
    }

    public void setSecondQuarterDTO(SecondQuarterDTO secondQuarterDTO) {
        this.secondQuarterDTO = secondQuarterDTO;
    }

    public ThirdQuarterDTO getThirdQuarterDTO() {
        return thirdQuarterDTO;
    }

    public void setThirdQuarterDTO(ThirdQuarterDTO thirdQuarterDTO) {
        this.thirdQuarterDTO = thirdQuarterDTO;
    }

    public ForthQuarterDTO getForthQuarterDTO() {
        return forthQuarterDTO;
    }

    public void setForthQuarterDTO(ForthQuarterDTO forthQuarterDTO) {
        this.forthQuarterDTO = forthQuarterDTO;
    }

    public ExtraTimeDTO getExtraTimeDTO() {
        return extraTimeDTO;
    }

    public void setExtraTimeDTO(ExtraTimeDTO extraTimeDTO) {
        this.extraTimeDTO = extraTimeDTO;
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
        return "MarkAsFavouriteDTO{" +
                "matchId=" + matchId +
                ", headerDTO=" + headerDTO +
                ", matchDTO=" + matchDTO +
                ", firstQuarterDTO=" + firstQuarterDTO +
                ", secondQuarterDTO=" + secondQuarterDTO +
                ", thirdQuarterDTO=" + thirdQuarterDTO +
                ", forthQuarterDTO=" + forthQuarterDTO +
                ", extraTimeDTO=" + extraTimeDTO +
                ", gameCode='" + gameCode + '\'' +
                ", seassonCode='" + seassonCode + '\'' +
                '}';
    }
}
