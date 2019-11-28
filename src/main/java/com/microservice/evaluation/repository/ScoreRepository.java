package com.microservice.evaluation.repository;

import com.microservice.evaluation.model.document.Score;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;


public interface ScoreRepository extends ReactiveMongoRepository<Score, String> {
  Flux<Score> findByIdEvaluation(String idEvaluation);
}
