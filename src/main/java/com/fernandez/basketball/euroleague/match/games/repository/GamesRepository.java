package com.fernandez.basketball.euroleague.match.games.repository;

import com.fernandez.basketball.euroleague.match.games.dto.GamesScrappingDTO;
import com.fernandez.basketball.euroleague.match.playbyplay.entity.mongo.MatchMongo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesRepository extends MongoRepository<GamesScrappingDTO,String > {

    Page<GamesScrappingDTO> findAllBySeassonCodeAndTeam(String seassonCode, String team, Pageable pageable);

    List<GamesScrappingDTO> findAllBySeassonCodeAndTeam(String seasoncode,String team);


}
