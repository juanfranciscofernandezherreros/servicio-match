package com.fernandez.basketball.euroleague.match.playbyplay.adapter;

import com.fernandez.basketball.euroleague.match.playbyplay.dto.*;
import com.fernandez.basketball.euroleague.match.playbyplay.entity.*;

import java.util.ArrayList;
import java.util.List;

public class MatchAdapter {

    public static Match mapToEntity(MatchDTO matchDTO){
        Match match = new Match();
        match.setLive(matchDTO.getLive());
        match.setTeamA(matchDTO.getTeamA());
        match.setTeamB(matchDTO.getTeamB());
        match.setCodeTeamA(matchDTO.getCodeTeamA());
        match.setCodeTeamB(matchDTO.getCodeTeamB());
        match.setActualQuarter(matchDTO.getActualQuarter());
        List<FirstQuarter> firstQuarterList = new ArrayList<>();
        List<SecondQuarter> secondQuarterList = new ArrayList<>();
        List<ThirdQuarter> thirdQuarterList = new ArrayList<>();
        List<ForthQuarter> forthQuarterList = new ArrayList<>();
        List<ExtraTime> extraTimeList = new ArrayList<>();
        for (FirstQuarterDTO firstQuarterDTO : matchDTO.getFirstQuarter()) {
            FirstQuarter firstQuarter = new FirstQuarter();
            firstQuarter.setType(firstQuarterDTO.getType());
            firstQuarter.setNumberofplay(firstQuarterDTO.getNumberofplay());
            firstQuarter.setCodeteam(firstQuarterDTO.getCodeteam());
            firstQuarter.setPlayerId(firstQuarterDTO.getPlayerId());
            firstQuarter.setPlaytype(firstQuarterDTO.getPlaytype());
            firstQuarter.setPlayer(firstQuarterDTO.getPlayer());
            firstQuarter.setTeam(firstQuarterDTO.getTeam());
            firstQuarter.setDorsal(firstQuarterDTO.getDorsal());
            firstQuarter.setMinute(firstQuarterDTO.getMinute());
            firstQuarter.setMarkertime(firstQuarterDTO.getMarkertime());
            firstQuarter.setPointsA(firstQuarterDTO.getPointsA());
            firstQuarter.setPointsB(firstQuarterDTO.getPointsB());
            firstQuarter.setComment(firstQuarterDTO.getComment());
            firstQuarter.setPlayinfo(firstQuarterDTO.getPlayinfo());
            firstQuarterList.add(firstQuarter);
        }
        for (SecondQuarterDTO secondQuarterDTO : matchDTO.getSecondQuarter()) {
            SecondQuarter secondQuarter = new SecondQuarter();
            secondQuarter.setType(secondQuarterDTO.getType());
            secondQuarter.setNumberofplay(secondQuarterDTO.getNumberofplay());
            secondQuarter.setCodeteam(secondQuarterDTO.getCodeteam());
            secondQuarter.setPlayerId(secondQuarterDTO.getPlayerId());
            secondQuarter.setPlaytype(secondQuarterDTO.getPlaytype());
            secondQuarter.setPlayer(secondQuarterDTO.getPlayer());
            secondQuarter.setTeam(secondQuarterDTO.getTeam());
            secondQuarter.setDorsal(secondQuarterDTO.getDorsal());
            secondQuarter.setMinute(secondQuarterDTO.getMinute());
            secondQuarter.setMarkertime(secondQuarterDTO.getMarkertime());
            secondQuarter.setPointsA(secondQuarterDTO.getPointsA());
            secondQuarter.setPointsB(secondQuarterDTO.getPointsB());
            secondQuarter.setComment(secondQuarterDTO.getComment());
            secondQuarter.setPlayinfo(secondQuarterDTO.getPlayinfo());
            secondQuarterList.add(secondQuarter);
        }
        for (ThirdQuarterDTO thirdQuarterDTO : matchDTO.getThirdQuarter()) {
            ThirdQuarter thirdQuarter = new ThirdQuarter();
            thirdQuarter.setType(thirdQuarterDTO.getType());
            thirdQuarter.setNumberofplay(thirdQuarterDTO.getNumberofplay());
            thirdQuarter.setCodeteam(thirdQuarterDTO.getCodeteam());
            thirdQuarter.setPlayerId(thirdQuarterDTO.getPlayerId());
            thirdQuarter.setPlaytype(thirdQuarterDTO.getPlaytype());
            thirdQuarter.setPlayer(thirdQuarterDTO.getPlayer());
            thirdQuarter.setTeam(thirdQuarterDTO.getTeam());
            thirdQuarter.setDorsal(thirdQuarterDTO.getDorsal());
            thirdQuarter.setMinute(thirdQuarterDTO.getMinute());
            thirdQuarter.setMarkertime(thirdQuarterDTO.getMarkertime());
            thirdQuarter.setPointsA(thirdQuarterDTO.getPointsA());
            thirdQuarter.setPointsB(thirdQuarterDTO.getPointsB());
            thirdQuarter.setComment(thirdQuarterDTO.getComment());
            thirdQuarter.setPlayinfo(thirdQuarterDTO.getPlayinfo());
            thirdQuarterList.add(thirdQuarter);
        }
        for (ForthQuarterDTO forthQuarterDTO : matchDTO.getForthQuarter()) {
            ForthQuarter forthQuarter = new ForthQuarter();
            forthQuarter.setType(forthQuarterDTO.getType());
            forthQuarter.setNumberofplay(forthQuarterDTO.getNumberofplay());
            forthQuarter.setCodeteam(forthQuarterDTO.getCodeteam());
            forthQuarter.setPlayerId(forthQuarterDTO.getPlayerId());
            forthQuarter.setPlaytype(forthQuarterDTO.getPlaytype());
            forthQuarter.setPlayer(forthQuarterDTO.getPlayer());
            forthQuarter.setTeam(forthQuarterDTO.getTeam());
            forthQuarter.setDorsal(forthQuarterDTO.getDorsal());
            forthQuarter.setMinute(forthQuarterDTO.getMinute());
            forthQuarter.setMarkertime(forthQuarterDTO.getMarkertime());
            forthQuarter.setPointsA(forthQuarterDTO.getPointsA());
            forthQuarter.setPointsB(forthQuarterDTO.getPointsB());
            forthQuarter.setComment(forthQuarterDTO.getComment());
            forthQuarter.setPlayinfo(forthQuarterDTO.getPlayinfo());
            forthQuarterList.add(forthQuarter);
        }
        for (ExtraTimeDTO extraTimeDTO : matchDTO.getExtraTime()) {
            ExtraTime extraTime = new ExtraTime();
            extraTime.setType(extraTimeDTO.getType());
            extraTime.setNumberofplay(extraTimeDTO.getNumberofplay());
            extraTime.setCodeteam(extraTimeDTO.getCodeteam());
            extraTime.setPlayerId(extraTimeDTO.getPlayerId());
            extraTime.setPlaytype(extraTimeDTO.getPlaytype());
            extraTime.setPlayer(extraTimeDTO.getPlayer());
            extraTime.setTeam(extraTimeDTO.getTeam());
            extraTime.setDorsal(extraTimeDTO.getDorsal());
            extraTime.setMinute(extraTimeDTO.getMinute());
            extraTime.setMarkertime(extraTimeDTO.getMarkertime());
            extraTime.setPointsA(extraTimeDTO.getPointsA());
            extraTime.setPointsB(extraTimeDTO.getPointsB());
            extraTime.setComment(extraTimeDTO.getComment());
            extraTime.setPlayinfo(extraTimeDTO.getPlayinfo());
            extraTimeList.add(extraTime);
        }
        match.setFirstQuarter(firstQuarterList);
        match.setSecondQuarter(secondQuarterList);
        match.setThirdQuarter(thirdQuarterList);
        match.setForthQuarter(forthQuarterList);
        match.setExtraTime(extraTimeList);
        return match;
    }

}
