package com.fernandez.basketball.euroleague.match.common.repository;

import com.fernandez.basketball.euroleague.match.playbyplay.entity.Match;
import com.fernandez.basketball.euroleague.match.playbyplay.entity.ThirdQuarter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThirdQuarterRepository extends JpaRepository<ThirdQuarter, Long> {
    List<ThirdQuarter> findAllByMatch(Match match);
}
