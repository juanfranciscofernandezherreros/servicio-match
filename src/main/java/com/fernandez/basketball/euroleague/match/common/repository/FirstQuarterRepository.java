package com.fernandez.basketball.euroleague.match.common.repository;

import com.fernandez.basketball.euroleague.match.playbyplay.entity.Quarter;
import com.fernandez.basketball.euroleague.match.playbyplay.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirstQuarterRepository extends JpaRepository<Quarter, Long> {
    List<Quarter> findAllByMatch(Match match);

    void deleteBynumberofplay(Integer numberOfPlay);

    void findBynumberofplay(String numberOfPlay);

    Quarter findBygamecodeAndSeassoncodeAndNumberofplay(String gamecode, String seassoncode,Integer numberofplay);
}
