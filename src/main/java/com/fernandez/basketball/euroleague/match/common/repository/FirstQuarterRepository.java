package com.fernandez.basketball.euroleague.match.common.repository;

import com.fernandez.basketball.euroleague.match.playbyplay.entity.FirstQuarter;
import com.fernandez.basketball.euroleague.match.playbyplay.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirstQuarterRepository extends JpaRepository<FirstQuarter, Long> {
    List<FirstQuarter> findAllByMatch(Match match);
}
