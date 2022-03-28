package com.example.projetspring.repositories;

import com.example.projetspring.Entities.Achievements;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAchievementsRepository extends CrudRepository<Achievements, Long> {
    @Query("FROM Achievements ORDER BY score ASC")
    List<Achievements> findAllOrderByScoreTotalAsc();
}
