package com.fernandez.basketball.euroleague.match.playbyplay.repository;

import com.fernandez.basketball.euroleague.match.playbyplay.entity.mongo.MatchMongo;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchMongoRepository extends CrudRepository<MatchMongo, Long> {


    MatchMongo findByGameCodeAndSeassonCode(String gameCode, String seassonCode);

    List<MatchMongo> findBySeassonCode(String seasoncode);
}
