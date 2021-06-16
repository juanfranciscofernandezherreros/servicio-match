package com.fernandez.basketball.euroleague.match.playbyplay.entity.mongo;

import com.fernandez.basketball.euroleague.match.playbyplay.dto.MatchDTO;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.List;

@Document("dataDTO")
public class MatchMongo {

    @Id
    private String id;

    private String gameCode;

    private String seassonCode;

    private MatchDTO matchDTO;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public MatchDTO getMatchDTO() {
        return matchDTO;
    }

    public void setMatchDTO(MatchDTO matchDTO) {
        this.matchDTO = matchDTO;
    }

    @Override
    public String toString() {
        return "MatchMongo{" +
                "id='" + id + '\'' +
                ", gameCode='" + gameCode + '\'' +
                ", seassonCode='" + seassonCode + '\'' +
                ", matchDTO=" + matchDTO +
                '}';
    }
}
