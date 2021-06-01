package com.fernandez.basketball.euroleague.teams.repository;

import com.fernandez.basketball.euroleague.teams.dto.TeamsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsRepository extends MongoRepository<TeamsDTO,String > {

    Page<TeamsDTO> findAllTeamsBySeasson(String seasson, Pageable pageable);
 }
