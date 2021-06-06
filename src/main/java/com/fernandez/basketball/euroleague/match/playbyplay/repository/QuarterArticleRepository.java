package com.fernandez.basketball.euroleague.match.playbyplay.repository;

import com.fernandez.basketball.euroleague.match.playbyplay.entity.jpa.QuarterArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuarterArticleRepository extends JpaRepository<QuarterArticle, Long> {
}
