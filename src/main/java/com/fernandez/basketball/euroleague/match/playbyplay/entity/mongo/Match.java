package com.fernandez.basketball.euroleague.match.playbyplay.entity.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("dataDTO")
public class Match {

    @Id
    private String id;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id='" + id + '\'' +
                '}';
    }
}
