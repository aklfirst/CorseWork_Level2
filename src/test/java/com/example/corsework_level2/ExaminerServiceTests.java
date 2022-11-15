package com.example.corsework_level2;


import com.example.coursework_level2.domain.Question;
import com.example.coursework_level2.exceptions.QuestionAlreadyExistsException;
import com.example.coursework_level2.exceptions.TooManyQuestionsException;
import com.example.coursework_level2.service.ExaminerService;
import com.example.coursework_level2.service.ExaminerServiceImpl;
import com.example.coursework_level2.service.JavaQuestionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.mid;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)


class ExaminerServiceTests {

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

    }

        @Test
        void testRandomQuestion() {

            Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(new ArrayList<>(questionsSample).get(1));

            Set<Question> expected = new HashSet<>();
            expected.add(new Question("Методы каких типов бывают?", "статические и нестатические"));

            Assertions.assertThat(javaQuestionService.getRandomQuestion().toString())
                    .isEqualTo(SetToString(expected, 1));

        }

        @Test
        void testBadRequest() {
            assertThatExceptionOfType(TooManyQuestionsException.class)
                    .isThrownBy(() -> examinerService.getQuestions(9));

        }


    public String SetToString(Set set, int position) {
        return mid(set.toString(),
                position,
                set.toString().length()-2 );
    }



}
