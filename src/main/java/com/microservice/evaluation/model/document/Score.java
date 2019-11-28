package com.microservice.evaluation.model.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "scores")
public class Score {
  @Id
  private String id;
  @NotNull
  private String idEvaluation;
  @NotNull
  private String idStudent;
  @NotNull
  private Double score;

  public Score() {
  }

  public Score(String id, String idEvaluation, String idStudent, Double score) {
    this.id = id;
    this.idEvaluation = idEvaluation;
    this.idStudent = idStudent;
    this.score = score;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getIdEvaluation() {
    return idEvaluation;
  }

  public void setIdEvaluation(String idEvaluation) {
    this.idEvaluation = idEvaluation;
  }

  public String getIdStudent() {
    return idStudent;
  }

  public void setIdStudent(String idStudent) {
    this.idStudent = idStudent;
  }

  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }
}
