package com.microservice.evaluation.service;

import com.microservice.evaluation.model.dto.EvaluationDto;
import com.microservice.evaluation.model.dto.ScoreDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EvaluationService {
  Flux<EvaluationDto> findAll();
  Mono<EvaluationDto> findById(String id);
  Mono<EvaluationDto> create(EvaluationDto evaluation);
  Mono<EvaluationDto> update(EvaluationDto evaluation, String id);
  Mono<Void> delete(String id);
  Flux<ScoreDto> findByIdEvaluation(String idEvaluation);
  Mono<ScoreDto> findByIdScore(String id);
  Mono<ScoreDto> createScore(ScoreDto score);
  Mono<ScoreDto> updateScore(ScoreDto score, String id);
}
