package com.fernandez.basketball.euroleague.match.playbyplay.entity.mongo;

import lombok.Data;

import javax.persistence.Id;

@Data
public class FirstQuarter {

    @Id
    private String id;

    private String playtype;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaytype() {
        return playtype;
    }

    public void setPlaytype(String playtype) {
        this.playtype = playtype;
    }

    @Override
    public String toString() {
        return "FirstQuarter{" +
                "id='" + id + '\'' +
                ", playtype='" + playtype + '\'' +
                '}';
    }
}
