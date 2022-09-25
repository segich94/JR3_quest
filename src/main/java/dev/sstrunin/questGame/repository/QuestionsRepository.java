package dev.sstrunin.questGame.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.sstrunin.questGame.entity.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuestionsRepository {

    private static final Logger LOGGER = LogManager.getLogger(QuestionsRepository.class);
    private final List<Question> questions = new ArrayList<>();
    public static final String WIN_GAME = "Поздравляю! \n Ты победил. =)";
    public static final String LOSE_GAME = "Ты проиграл =(";

    public void parseQuestion() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Question> result;
        File file;

        try {
            file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("story.json")).getFile());
            result = objectMapper.readValue(file,
                    new TypeReference<List<Question>>() {
                    });
        } catch (IOException e) {
            LOGGER.error("Error with parse Story.json", e);
            throw new RuntimeException(e);
        }
        questions.addAll(result);
    }

    public List<Question> getQuestions() {
        if (questions.isEmpty()) {
            parseQuestion();
        }
        return questions;
    }

    public boolean isCorrectAnswer(int questId, int answer) {
        return questions.get(questId).getRightAnswer() == answer;
    }
}
