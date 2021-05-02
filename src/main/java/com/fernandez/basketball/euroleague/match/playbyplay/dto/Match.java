
package com.fernandez.basketball.euroleague.match.playbyplay.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Live",
    "TeamA",
    "TeamB",
    "CodeTeamA",
    "CodeTeamB",
    "ActualQuarter",
    "FirstQuarter",
    "SecondQuarter",
    "ThirdQuarter",
    "ForthQuarter",
    "ExtraTime"
})
@Generated("jsonschema2pojo")
public class Match {

    @JsonProperty("Live")
    private Boolean live;
    @JsonProperty("TeamA")
    private String teamA;
    @JsonProperty("TeamB")
    private String teamB;
    @JsonProperty("CodeTeamA")
    private String codeTeamA;
    @JsonProperty("CodeTeamB")
    private String codeTeamB;
    @JsonProperty("ActualQuarter")
    private Integer actualQuarter;
    @JsonProperty("FirstQuarter")
    private List<FirstQuarter> firstQuarter = null;
    @JsonProperty("SecondQuarter")
    private List<SecondQuarter> secondQuarter = null;
    @JsonProperty("ThirdQuarter")
    private List<ThirdQuarter> thirdQuarter = null;
    @JsonProperty("ForthQuarter")
    private List<ForthQuarter> forthQuarter = null;
    @JsonProperty("ExtraTime")
    private List<ExtraTime> extraTime = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Live")
    public Boolean getLive() {
        return live;
    }

    @JsonProperty("Live")
    public void setLive(Boolean live) {
        this.live = live;
    }

    @JsonProperty("TeamA")
    public String getTeamA() {
        return teamA;
    }

    @JsonProperty("TeamA")
    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    @JsonProperty("TeamB")
    public String getTeamB() {
        return teamB;
    }

    @JsonProperty("TeamB")
    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    @JsonProperty("CodeTeamA")
    public String getCodeTeamA() {
        return codeTeamA;
    }

    @JsonProperty("CodeTeamA")
    public void setCodeTeamA(String codeTeamA) {
        this.codeTeamA = codeTeamA;
    }

    @JsonProperty("CodeTeamB")
    public String getCodeTeamB() {
        return codeTeamB;
    }

    @JsonProperty("CodeTeamB")
    public void setCodeTeamB(String codeTeamB) {
        this.codeTeamB = codeTeamB;
    }

    @JsonProperty("ActualQuarter")
    public Integer getActualQuarter() {
        return actualQuarter;
    }

    @JsonProperty("ActualQuarter")
    public void setActualQuarter(Integer actualQuarter) {
        this.actualQuarter = actualQuarter;
    }

    @JsonProperty("FirstQuarter")
    public List<FirstQuarter> getFirstQuarter() {
        return firstQuarter;
    }

    @JsonProperty("FirstQuarter")
    public void setFirstQuarter(List<FirstQuarter> firstQuarter) {
        this.firstQuarter = firstQuarter;
    }

    @JsonProperty("SecondQuarter")
    public List<SecondQuarter> getSecondQuarter() {
        return secondQuarter;
    }

    @JsonProperty("SecondQuarter")
    public void setSecondQuarter(List<SecondQuarter> secondQuarter) {
        this.secondQuarter = secondQuarter;
    }

    @JsonProperty("ThirdQuarter")
    public List<ThirdQuarter> getThirdQuarter() {
        return thirdQuarter;
    }

    @JsonProperty("ThirdQuarter")
    public void setThirdQuarter(List<ThirdQuarter> thirdQuarter) {
        this.thirdQuarter = thirdQuarter;
    }

    @JsonProperty("ForthQuarter")
    public List<ForthQuarter> getForthQuarter() {
        return forthQuarter;
    }

    @JsonProperty("ForthQuarter")
    public void setForthQuarter(List<ForthQuarter> forthQuarter) {
        this.forthQuarter = forthQuarter;
    }

    @JsonProperty("ExtraTime")
    public List<ExtraTime> getExtraTime() {
        return extraTime;
    }

    @JsonProperty("ExtraTime")
    public void setExtraTime(List<ExtraTime> extraTime) {
        this.extraTime = extraTime;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Match{" +
                "live=" + live +
                ", teamA='" + teamA + '\'' +
                ", teamB='" + teamB + '\'' +
                ", codeTeamA='" + codeTeamA + '\'' +
                ", codeTeamB='" + codeTeamB + '\'' +
                ", actualQuarter=" + actualQuarter +
                ", firstQuarter=" + firstQuarter +
                ", secondQuarter=" + secondQuarter +
                ", thirdQuarter=" + thirdQuarter +
                ", forthQuarter=" + forthQuarter +
                ", extraTime=" + extraTime +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
