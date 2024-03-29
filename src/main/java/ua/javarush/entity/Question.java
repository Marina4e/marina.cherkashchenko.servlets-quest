package ua.javarush.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private String text;
    private Integer id;
    private Boolean hasNextStep;
    private Boolean isWin;
    private List<Action> answers;
}
