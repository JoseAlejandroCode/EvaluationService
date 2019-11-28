package com.microservice.evaluation.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EvaluationDto implements Serializable {

  private String id;
  @NotEmpty
  private String name;
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date dateEvaluation;
  @NotNull
  private CourseDto course;

  private List<ScoreDto> scores;

  public EvaluationDto() {
    this.scores = new ArrayList<>();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDateEvaluation() {
    return dateEvaluation;
  }

  public void setDateEvaluation(Date dateEvaluation) {
    this.dateEvaluation = dateEvaluation;
  }

  public CourseDto getCourse() {
    return course;
  }

  public void setCourse(CourseDto course) {
    this.course = course;
  }

  public List<ScoreDto> getScores() {
    return scores;
  }

  public void setScores(List<ScoreDto> scores) {
    this.scores = scores;
  }

  public void addScore(ScoreDto score) {
    this.scores.add(score);
  }
}
