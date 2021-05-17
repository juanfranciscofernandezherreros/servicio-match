package com.fernandez.basketball.euroleague.match.playbyplay.dto;


public class MarkAsFavouriteDTO {

    private FirstQuarterDTO firstQuarterDTO;
    private SecondQuarterDTO secondQuarterDTO;
    private ThirdQuarterDTO thirdQuarterDTO;
    private ForthQuarterDTO forthQuarterDTO;
    private ExtraTimeDTO extraTimeDTO;

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

    @Override
    public String toString() {
        return "MarkAsFavouriteDTO{" +
                "firstQuarterDTO=" + firstQuarterDTO +
                ", secondQuarterDTO=" + secondQuarterDTO +
                ", thirdQuarterDTO=" + thirdQuarterDTO +
                ", forthQuarterDTO=" + forthQuarterDTO +
                ", extraTimeDTO=" + extraTimeDTO +
                '}';
    }
}
