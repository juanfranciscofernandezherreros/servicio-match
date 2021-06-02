package com.fernandez.basketball.euroleague.match.games.repository;

import com.fernandez.basketball.euroleague.match.games.dto.GamesScrappingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends MongoRepository<GamesScrappingDTO,String > {

    Page<GamesScrappingDTO> findAllBySeassonCodeAndTeam(String seassonCode, String team, Pageable pageable);

}
