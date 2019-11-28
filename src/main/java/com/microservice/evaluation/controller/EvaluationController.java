package com.microservice.evaluation.controller;

import com.microservice.evaluation.model.dto.EvaluationDto;
import com.microservice.evaluation.model.dto.ScoreDto;
import com.microservice.evaluation.service.EvaluationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;


@Api(value="evaluations", description="Operations pertaining to evaluations")
@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {

  @Autowired
  private EvaluationService evaluationService;

  @ApiOperation(value = "View a list of available evaluations", response = EvaluationDto.class)
  @GetMapping
  public Mono<ResponseEntity<Flux<EvaluationDto>>> findAll(){
    return Mono.just(ResponseEntity
            .ok().contentType(MediaType.APPLICATION_JSON).body(evaluationService.findAll()));
  }

  @ApiOperation(value = "View a evaluation by ID", response = EvaluationDto.class)
  @GetMapping("/{id}")
  public Mono<ResponseEntity<EvaluationDto>> finById(@PathVariable String id){
    return evaluationService.findById(id)
            .map(evaluation -> ResponseEntity
            .ok().contentType(MediaType.APPLICATION_JSON).body(evaluation));
  }

  @ApiOperation(value = "Save a evaluation", response = EvaluationDto.class)
  @PostMapping
  public  Mono<ResponseEntity<EvaluationDto>> save(@Valid @RequestBody EvaluationDto evaluation) {
    return evaluationService.create(evaluation)
            .map(s -> ResponseEntity
            .created(URI.create("/api/evaluations")).contentType(MediaType.APPLICATION_JSON).body(s));
  }

  @ApiOperation(value = "Update a evaluation", response = EvaluationDto.class)
  @PutMapping("/{id}")
  public Mono<ResponseEntity<EvaluationDto>> update(@RequestBody EvaluationDto evaluation, @PathVariable String id){
    return evaluationService.update(evaluation, id)
            .map(s -> ResponseEntity
                .created(URI.create("/api/evaluations")).contentType(MediaType.APPLICATION_JSON).body(s));
  }

  @ApiOperation(value = "Delete of available evaluation", response = Mono.class)
  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
    return evaluationService.delete(id)
            .flatMap(p -> Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
  }

  @PostMapping("/score")
  public Mono<ResponseEntity<ScoreDto>> createScore(@RequestBody ScoreDto score) {
    return evaluationService.createScore(score)
            .map(s -> ResponseEntity
                    .created(URI.create("/api/evaluations/score")).contentType(MediaType.APPLICATION_JSON).body(s));
  }

  @PutMapping("/score/{id}")
  public Mono<ResponseEntity<ScoreDto>> updateScore(@RequestBody ScoreDto score, @PathVariable String id) {
    return evaluationService.updateScore(score, id)
            .map(s -> ResponseEntity
                    .created(URI.create("/api/score")).contentType(MediaType.APPLICATION_JSON).body(s));
  }
}
