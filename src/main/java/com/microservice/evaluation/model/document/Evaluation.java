package com.microservice.evaluation.model.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "evaluations")
public class Evaluation {
  @Id
  private String id;
  @NotEmpty
  private String name;
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date dateEvaluation;
  @NotNull
  private String idCourse;

  public Evaluation() {
  }

  public Evaluation(String id, String name, Date dateEvaluation, String idCourse) {
    this.id = id;
    this.name = name;
    this.dateEvaluation = dateEvaluation;
    this.idCourse = idCourse;
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

  public String getIdCourse() {
    return idCourse;
  }

  public void setIdCourse(String idCourse) {
    this.idCourse = idCourse;
  }
}
