package com.microservice.evaluation.component;

import com.microservice.evaluation.model.document.Evaluation;
import com.microservice.evaluation.model.dto.EvaluationDto;
import org.springframework.stereotype.Component;

@Component
public class EvaluationConverter {

  public EvaluationDto convertToDto(Evaluation evaluation){
    EvaluationDto evaluationDto = new EvaluationDto();
    evaluationDto.setId(evaluation.getId());
    evaluation.setName(evaluation.getName());
    evaluation.setDateEvaluation(evaluation.getDateEvaluation());
    return evaluationDto;
  }

  public Evaluation convertToDocument(EvaluationDto evaluationDTO){
    Evaluation evaluation = new Evaluation();
    evaluation.setId(evaluationDTO.getId());
    evaluation.setDateEvaluation(evaluationDTO.getDateEvaluation());
    evaluation.setName(evaluationDTO.getName());
    evaluation.setIdCourse(evaluationDTO.getCourse().getId());
    return evaluation;
  }

}
