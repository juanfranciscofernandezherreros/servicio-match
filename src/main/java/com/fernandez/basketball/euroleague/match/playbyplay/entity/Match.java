package com.fernandez.basketball.euroleague.match.playbyplay.entity;

import com.fernandez.basketball.euroleague.match.playbyplay.dto.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name="match_id")
    private List<FirstQuarter> firstQuarter;

}
