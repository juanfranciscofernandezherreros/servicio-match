package com.fernandez.basketball.euroleague.match.playbyplay.repository;

import com.fernandez.basketball.euroleague.match.playbyplay.entity.mongo.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchMongoRepository extends CrudRepository<Match, Long> {

    Match findByGameCodeAndSeassonCode(String gameCode, String seassonCode);
}
