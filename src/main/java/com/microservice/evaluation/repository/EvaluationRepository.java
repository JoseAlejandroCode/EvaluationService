package com.microservice.evaluation.repository;

import com.microservice.evaluation.model.document.Evaluation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface EvaluationRepository extends ReactiveMongoRepository<Evaluation, String> {

}
