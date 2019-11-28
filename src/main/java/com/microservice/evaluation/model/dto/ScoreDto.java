package com.microservice.evaluation.model.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ScoreDto implements Serializable {

  private String id;
  @NotNull
  private String idEvaluation;

  private StudentDto student;
  @NotNull
  private Double score;

  public ScoreDto() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public StudentDto getStudent() {
    return student;
  }

  public void setStudent(StudentDto student) {
    this.student = student;
  }

  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }

  public String getIdEvaluation() {
    return idEvaluation;
  }

  public void setIdEvaluation(String idEvaluation) {
    this.idEvaluation = idEvaluation;
  }
}
