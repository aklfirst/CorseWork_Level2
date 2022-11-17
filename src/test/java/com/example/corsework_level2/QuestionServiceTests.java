package com.example.corsework_level2;

import com.example.coursework_level2.domain.Question;
import com.example.coursework_level2.exceptions.QuestionAlreadyExistsException;
import com.example.coursework_level2.exceptions.QuestionNotFoundException;
import com.example.coursework_level2.service.JavaQuestionService;
import com.example.coursework_level2.service.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuestionServiceTests {

    private final QuestionService out = new JavaQuestionService();


    @Test
    void checkAdd() {

        Question questionToAddActual1 = new Question("Попробуй Джава-Джава","Мне это надо - надо");
        Question questionToAddActual2 = new Question("Какие коллекции вам известны?","List / Set / Map");
        Question questionToAddActual3 = new Question("Какие коллекции вам известны?","List / Set / Map");

        out.add(questionToAddActual1.getQuestion(),questionToAddActual1.getAnswer());
        out.add(questionToAddActual2.getQuestion(),questionToAddActual2.getAnswer());
        out.add(questionToAddActual3.getQuestion(),questionToAddActual3.getAnswer());

        assertThat(out.getAll()).contains(questionToAddActual1);
        assertThat(out.getAll()).contains(questionToAddActual2);

        assertThat(out.getAll())
                .hasSize(13);

        }

    @Test
    void checkRemoveAndFind() {

        Question toTestRemove = new Question("Какие циклы в Java вы знаете?", "while; do while; for");

        out.remove(toTestRemove);
        assertThat(out.getAll())
                .doesNotContain(toTestRemove);

    }


}





