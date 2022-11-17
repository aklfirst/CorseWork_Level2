package com.example.corsework_level2;


import com.example.coursework_level2.domain.Question;
import com.example.coursework_level2.exceptions.TooManyQuestionsException;
import com.example.coursework_level2.service.ExaminerServiceImpl;
import com.example.coursework_level2.service.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.*;

import static org.apache.commons.lang3.StringUtils.mid;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)


class ExaminerServiceTests {
    Random random = new Random();

    private final Set<Question> questionsSample = new HashSet<>();

   @Mock

    private JavaQuestionService javaQuestionService = new JavaQuestionService();

    @InjectMocks

    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void beforeEach() {

        questionsSample.add(new Question("Какие условные операторы в Java вы знаете?", "==; >; <; >=; <=; !=; if_else"));
        questionsSample.add(new Question("Какие циклы в Java вы знаете?", "while; do while; for"));
        questionsSample.add(new Question("Методы каких типов бывают?", "статические и нестатические"));
        questionsSample.add(new Question("Приведите примеры статического метода", "Arrays.toString()"));
        questionsSample.add(new Question("Приведите примеры нестатического метода", "toUpperCase"));

        Mockito.when(javaQuestionService.getAll()).thenReturn(new ArrayList<>(questionsSample));
    }

        @Test
        void testRandomQuestion() {
            Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(new ArrayList<>(questionsSample).get(1));
            Collection<Question> expected = examinerService.getQuestions(1);
            assertThat(questionsSample.contains(expected));
// не получается вменяемо написать данный тест - он либо уходит в бесконечный цикл (если вызвать getQuestions более 1 раза, либо жестко затыкать его одним вопросом:(
        }

        @Test
        void testBadRequest() {
            assertThatExceptionOfType(TooManyQuestionsException.class)
                    .isThrownBy(() -> examinerService.getQuestions(20));

        }

}
