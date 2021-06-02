package com.fernandez.basketball.euroleague.match.common.repository;

import com.fernandez.basketball.euroleague.match.playbyplay.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    Optional<Match> findByGameCodeAndSeassonCode(String gameCode, String seassonCode);


}
