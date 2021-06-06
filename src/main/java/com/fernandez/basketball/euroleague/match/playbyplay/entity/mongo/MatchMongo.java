package com.fernandez.basketball.euroleague.match.playbyplay.entity.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("dataDTO")
public class MatchMongo {

    @Id
    private String id;

    private String gameCode;

    private String seassonCode;

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

    @Override
    public String toString() {
        return "Match{" +
                "id='" + id + '\'' +
                ", gameCode='" + gameCode + '\'' +
                ", seassonCode='" + seassonCode + '\'' +
                '}';
    }
}
