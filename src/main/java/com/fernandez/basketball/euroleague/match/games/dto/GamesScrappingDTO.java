package com.fernandez.basketball.euroleague.match.games.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GamesScrappingDTO {

    private String versus;
    private String matchLink;
}
