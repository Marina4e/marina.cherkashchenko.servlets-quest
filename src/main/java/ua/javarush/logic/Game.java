package ua.javarush.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import ua.javarush.entity.Question;
import ua.javarush.path.Resources;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.util.*;


@Log4j2
public class Game {
    private final ArrayList<Question> questions;
    private final Resources resources;
    private final ObjectMapper mapper;

    public Game(Resources resources, ObjectMapper mapper) {
        log.info("Initializing Game...");
        this.mapper = mapper;
        this.resources = resources;
        questions = readSteps();
        log.info("Game initialized.");
    }

    @SneakyThrows
    private ArrayList<Question> readSteps() {
        log.info("Reading Steps...");
        String pathToJsonProp = resources.getPathToJsonProp();
        File file = new File(pathToJsonProp);
        ArrayList<Question> result;
        log.info("Converting JSON to ArrayList<Step>...");
        result = mapper.readValue(file, mapper.getTypeFactory()
                .constructCollectionType(ArrayList.class, Question.class));
        log.info("Conversion completed.");
        log.info(result);
        log.info("Steps read.");
        return result;
    }

    public Question getStepById(Integer id) {
        log.info(id);
        Optional<Question> optionalStep = questions.stream()
                .filter(step -> Objects.equals(step.getId(), id))
                .findAny();
        log.info("Search completed.");
        if (optionalStep.isPresent()) {
            log.info(id);
        } else
            log.info(id);
        return optionalStep.orElse(null);
    }
}
