package com.example.projetspring.repositories;

import com.example.projetspring.Entities.Evaluation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEvaluationRepository extends CrudRepository<Evaluation, Long> {
}
