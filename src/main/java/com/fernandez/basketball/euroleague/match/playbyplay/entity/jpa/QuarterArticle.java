package com.fernandez.basketball.euroleague.match.playbyplay.entity.jpa;

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
@Table(name = "quarter_article")
public class QuarterArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String playInfo;

    private String gameCode;

    private String seassonCode;

    private String playerId;

    private String playerName;

    private String articleId;

    private String numberofplay;

    private String actualQuarter;

    private String markertime;

}
