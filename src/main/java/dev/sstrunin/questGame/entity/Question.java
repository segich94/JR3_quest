package dev.sstrunin.questGame.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Question {
    private int id;
    private String question;
    private String answer1;
    private String answer2;
    private int rightAnswer;
}
