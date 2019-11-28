package com.microservice.evaluation.service.impl;

import com.microservice.evaluation.component.EvaluationConverter;
import com.microservice.evaluation.component.ScoreConverter;
import com.microservice.evaluation.model.dto.EvaluationDto;
import com.microservice.evaluation.model.dto.ScoreDto;
import com.microservice.evaluation.repository.EvaluationRepository;
import com.microservice.evaluation.repository.ScoreRepository;
import com.microservice.evaluation.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EvaluationServiceImpl implements EvaluationService {

  @Autowired
  private EvaluationRepository evaluationRepository;

  @Autowired
  private ScoreRepository scoreRepository;

  @Autowired
  private ScoreConverter scoreConverter;

  @Autowired
  private EvaluationConverter evaluationConverter;

  @Override
  public Flux<EvaluationDto> findAll() {
    return evaluationRepository.findAll()
            .flatMap(evaluation ->  Mono.just(evaluationConverter.convertToDto(evaluation)))
            .flatMap(evaluation -> {
              evaluation.setScores(findByIdEvaluation(evaluation.getId()).collectList().block());
              return Mono.just(evaluation);
            });
  }

  @Override
  public Mono<EvaluationDto> findById(String id) {
    return evaluationRepository.findById(id)
            .flatMap(evaluation -> Mono.just(evaluationConverter.convertToDto(evaluation)))
            .flatMap(evaluation -> {
              evaluation.setScores(findByIdEvaluation(evaluation.getId()).collectList().block());
              return Mono.just(evaluation);
            });
  }

  @Override
  public Mono<EvaluationDto> create(EvaluationDto evaluation) {
    return evaluationRepository.save(evaluationConverter.convertToDocument(evaluation))
            .flatMap(s -> Mono.just(evaluationConverter.convertToDto(s)));
  }

  @Override
  public Mono<EvaluationDto> update(EvaluationDto evaluation, String id) {
    return findById(id).flatMap(e -> {
      e.setName(evaluation.getId());
      e.setDateEvaluation(evaluation.getDateEvaluation());
      return evaluationRepository.save(evaluationConverter.convertToDocument(e))
              .flatMap(ev -> Mono.just(evaluationConverter.convertToDto(ev)));
    });
  }

  @Override
  public Mono<Void> delete(String  id) {
    return findById(id)
              .flatMap(s -> evaluationRepository.delete(evaluationConverter.convertToDocument(s)));
  }

  @Override
  public Flux<ScoreDto> findByIdEvaluation(String idEvaluation) {
    return scoreRepository.findByIdEvaluation(idEvaluation)
            .flatMap(score -> Mono.just(scoreConverter.convertToDto(score)));
  }

  @Override
  public Mono<ScoreDto> findByIdScore(String id) {
    return scoreRepository.findById(id)
            .flatMap(s -> Mono.just(scoreConverter.convertToDto(s)));
  }

  @Override
  public Mono<ScoreDto> createScore(ScoreDto score) {
    return scoreRepository.save(scoreConverter.convertToDocument(score))
            .flatMap(s -> Mono.just(scoreConverter.convertToDto(s)));
  }

  @Override
  public Mono<ScoreDto> updateScore(ScoreDto score, String id) {
    return findByIdScore(id).flatMap(sc -> {
      sc.setScore(score.getScore());
      return scoreRepository.save(scoreConverter.convertToDocument(sc))
              .flatMap(s -> Mono.just(scoreConverter.convertToDto(s)));
    });
  }

}
