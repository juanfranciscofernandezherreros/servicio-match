package com.fernandez.basketball.euroleague.match.playbyplay.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fernandez.basketball.euroleague.match.playbyplay.dto.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Boolean live;
    private String teamA;
    private String teamB;
    private String codeTeamA;
    private String codeTeamB;
    private Integer actualQuarter;
    private String phase;
    private String date;
    private String round;
    private String gameCode;
    private String seassonCode;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="match_id")
    @JsonBackReference
    private List<FirstQuarter> firstQuarter;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="match_id")
    @JsonBackReference
    private List<SecondQuarter> secondQuarter;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="match_id")
    @JsonBackReference
    private List<ThirdQuarter> thirdQuarter;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="match_id")
    @JsonBackReference
    private List<ForthQuarter> forthQuarter;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="match_id")
    @JsonBackReference
    private List<ExtraTime> extraTime;
}
