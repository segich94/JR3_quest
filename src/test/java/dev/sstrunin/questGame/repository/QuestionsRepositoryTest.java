package dev.sstrunin.questGame.repository;

import dev.sstrunin.questGame.entity.Question;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionsRepositoryTest {
    private QuestionsRepository questionsRepository = new QuestionsRepository();
    @Disabled
    @Test
    void parseQuestionPositive(){
        List<Question> questions;

        Question exceptQuestion = new Question();
        exceptQuestion.setId(0);
        exceptQuestion.setAnswer1("");
        exceptQuestion.setAnswer2("");
        exceptQuestion.setRightAnswer(0);
        questions = questionsRepository.getQuestions();

        assertEquals(questions.get(0),exceptQuestion);
    }
}