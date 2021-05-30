package com.fernandez.basketball.euroleague.teams.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TeamsDTO {

    private String team;
    private String nameTeam;
    private String seasson;
    private String url;
}
