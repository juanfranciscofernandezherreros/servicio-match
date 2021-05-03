package com.fernandez.basketball.euroleague.match.playbyplay.adapter;

import com.fernandez.basketball.euroleague.match.playbyplay.dto.FirstQuarterDTO;
import com.fernandez.basketball.euroleague.match.playbyplay.dto.MatchDTO;
import com.fernandez.basketball.euroleague.match.playbyplay.entity.FirstQuarter;
import com.fernandez.basketball.euroleague.match.playbyplay.entity.Match;

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
        match.setFirstQuarter(firstQuarterList);
        return match;
    }

}
