package com.fernandez.basketball.euroleague.match.common.repository;

import com.fernandez.basketball.euroleague.match.playbyplay.entity.Match;
import com.fernandez.basketball.euroleague.match.playbyplay.entity.SecondQuarter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecondQuarterRepository extends JpaRepository<SecondQuarter, Long> {
    List<SecondQuarter> findAllByMatch(Match match);
}
