package com.fernandez.basketball.euroleague.match.playbyplay.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "secondquarter")
public class SecondQuarter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Integer type;
    private Integer numberofplay;
    private String codeteam;
    private String playerId;
    private String playtype;
    private String player;
    private String team;
    private String dorsal;
    private Integer minute;
    private String markertime;
    private String pointsA;
    private String pointsB;
    private String comment;
    private String playinfo;
    @ManyToOne(cascade = CascadeType.ALL)
    private Match match;
    private boolean markAsFavourite;

}
