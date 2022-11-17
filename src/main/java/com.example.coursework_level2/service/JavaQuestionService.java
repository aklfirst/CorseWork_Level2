package com.example.coursework_level2.service;

import com.example.coursework_level2.domain.Question;
import com.example.coursework_level2.exceptions.QuestionAlreadyExistsException;
import com.example.coursework_level2.exceptions.QuestionNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Map;
import java.util.*;

@Service

public class JavaQuestionService implements QuestionService  {

    Random random = new Random();
    private Set<Question> examQuestionSet = new HashSet<>();

    public JavaQuestionService() {
        this.examQuestionSet = examQuestionSet;
        addQuestionsLibrary();
    }

    private void addQuestionsLibrary () {
        examQuestionSet.add(new Question("Какие условные операторы в Java вы знаете?", "==; >; <; >=; <=; !=; if_else"));
        examQuestionSet.add(new Question("Какие циклы в Java вы знаете?", "while; do while; for"));
        examQuestionSet.add(new Question("Методы каких типов бывают?", "статические и нестатические"));
        examQuestionSet.add(new Question("Приведите примеры статического метода", "Arrays.toString()"));
        examQuestionSet.add(new Question("Приведите примеры нестатического метода", "toUpperCase"));
        examQuestionSet.add(new Question("Назовите типы переменных", "Примитивный и ссылочный"));
        examQuestionSet.add(new Question("Что такое переменные примитивного типа?", "Переменные, которые хранят в себе данные"));
        examQuestionSet.add(new Question("Что такое переменные ссылочного типа?", "Обьекты, хранящие не значения, а ссылки на данные из области памяти"));
        examQuestionSet.add(new Question("Приведите пример переменной ссылочного типа", "массивы, строки, листы"));
        examQuestionSet.add(new Question("Что такое инкапсуляция?", "Один из 3-х принципов ООП подразумевает разграничение доступа к данным и возможностям классов и объектов"));
        examQuestionSet.add(new Question("Что такое коллекции?", "это способы хранения обьектов, альтернативных массивам, которые дают иные, более широкие возможности для их вызова, обработки и изменения."));
    }

    @Override
    public Question add(String question, String answer) {
        Question questionToAdd = new Question(question, answer);
        examQuestionSet.add(questionToAdd);
        return questionToAdd;
    }

    @Override
    public Question remove(Question question) {
        examQuestionSet.remove(question);
        return question;
    }

    @Override
    public Collection <Question> getAll() {
        return new ArrayList<>(examQuestionSet);
        }

    @Override
    public Question getRandomQuestion() {
        return new ArrayList<>(examQuestionSet).get(random.nextInt(examQuestionSet.size()));
    }

}




