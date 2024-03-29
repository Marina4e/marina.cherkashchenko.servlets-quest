package ua.javarush.logic;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import ua.javarush.entity.Question;
import ua.javarush.path.Resources;
import ua.javarush.entity.Action;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


@ExtendWith(MockitoExtension.class)
class GameTest {
    static ArrayList<Question> expectedList;
    static Game game;
    @Mock
    Resources resources;


    @BeforeAll
    public static void init() {
        game = new Game(new Resources(), new ObjectMapper());
        expectedList = new ArrayList<>();
        expectedList.add(new Question("TestQuestion1", 1, true, false, new ArrayList<>
                (Arrays.asList(new Action("Action1", 2), new Action("Action2", 5)))));
        expectedList.add(new Question("TestQuestion2", 2, true, false, new ArrayList<>
                (Arrays.asList(new Action("Action3", 3), new Action("Action4", 6)))));
    }

    @Test
    void readStepsTest() {
        Mockito.doReturn("src/test/java/ua/javarush/resources/stepInfoForTesting.json").when(resources).getPathToJsonProp();
        ObjectMapper mapper = new ObjectMapper();
        String pathToJsonProp = resources.getPathToJsonProp();
        File file = new File(pathToJsonProp);
        ArrayList<Question> result = new ArrayList<>();
        try {
            result = mapper.readValue(file, mapper.getTypeFactory().
                    constructCollectionType(ArrayList.class, Question.class));
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        assertEquals(expectedList, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void getStepById_returnStepClassTest(int i) {
        Question step = game.getStepById(i);
        assertAll("step", () -> assertEquals(Question.class, step.getClass()),
                () -> assertEquals((int) step.getId(), i));
    }
}
