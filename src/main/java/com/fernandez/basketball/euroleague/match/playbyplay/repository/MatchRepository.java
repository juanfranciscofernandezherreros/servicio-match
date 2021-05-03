package com.fernandez.basketball.euroleague.match.playbyplay.repository;

import com.fernandez.basketball.euroleague.match.playbyplay.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}
