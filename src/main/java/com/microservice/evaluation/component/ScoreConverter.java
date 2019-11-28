package com.microservice.evaluation.component;

import com.microservice.evaluation.model.document.Score;
import com.microservice.evaluation.model.dto.ScoreDto;
import org.springframework.stereotype.Component;

@Component
public class ScoreConverter {

  public ScoreDto convertToDto(Score score){
    ScoreDto scoreDto = new ScoreDto();
    scoreDto.setId(score.getId());
    scoreDto.setScore(score.getScore());
    return scoreDto;
  }

  public Score convertToDocument(ScoreDto scoreDTO){
    Score score = new Score();
    score.setId(scoreDTO.getId());
    score.setScore(scoreDTO.getScore());
    score.setIdEvaluation(scoreDTO.getIdEvaluation());
    score.setIdStudent(scoreDTO.getStudent().getId());
    return score;
  }

}
