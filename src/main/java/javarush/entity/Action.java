package javarush.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Action {
    private String text;
    private Integer ledToStep;
}
