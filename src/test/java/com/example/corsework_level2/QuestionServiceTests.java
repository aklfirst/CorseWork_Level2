package com.example.corsework_level2;

import com.example.coursework_level2.domain.Question;
import com.example.coursework_level2.exceptions.QuestionAlreadyExistsException;
import com.example.coursework_level2.exceptions.QuestionNotFoundException;
import com.example.coursework_level2.service.JavaQuestionService;
import com.example.coursework_level2.service.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuestionServiceTests {

    private final QuestionService out = new JavaQuestionService();


    @Test
    void checkAdd() {

        Question questionToAddActual1 = new Question("Попробуй Джава-Джава","Мне это надо - надо");
        Question questionToAddActual2 = new Question("Какие коллекции вам известны?","List / Set / Map");

        out.add(questionToAddActual1.getQuestion(),questionToAddActual1.getAnswer());
        out.add(questionToAddActual2.getQuestion(),questionToAddActual2.getAnswer());

                Assertions.assertEquals(out.find(questionToAddActual1),questionToAddActual1);
        Assertions.assertEquals(out.find(questionToAddActual2),questionToAddActual2);

        assertThat(out.getAll())
                .hasSize(14);

        }

    @Test
    void checkRemoveAndFind() {

        Question toTestRemove = new Question("Какие циклы в Java вы знаете?", "while; do while; for");
        Question toTestFind = new Question("Какие условные операторы в Java вы знаете?", "==; >; <; >=; <=; !=; if_else");

        out.remove(toTestRemove);
        assertThat(out.getAll())
                .doesNotContain(toTestRemove);
        Assertions.assertEquals(out.find(toTestFind),toTestFind);

    }

    @Test
    public void negativeTestOnExceptions() {
        assertThatExceptionOfType(QuestionAlreadyExistsException.class)
                .isThrownBy(() -> out.add("Какие циклы в Java вы знаете?", "while; do while; for"));

        Question questionToTestErrors = new Question("Попробуй Джава-Джава","Мне это надо - надо");

        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> out.remove(questionToTestErrors));

        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> out.find(questionToTestErrors));

    }

}





