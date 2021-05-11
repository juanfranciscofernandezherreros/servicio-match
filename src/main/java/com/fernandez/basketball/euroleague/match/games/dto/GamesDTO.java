package com.fernandez.basketball.euroleague.match.games.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GamesDTO {

    private Long id;
    private String teamA;
    private String teamB;
    private String codeTeamA;
    private String codeTeamB;

}
