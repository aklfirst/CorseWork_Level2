package com.example.coursework_level2.service;

import com.example.coursework_level2.domain.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question remove(Question question);

    Collection <Question> getAll();

    Question getRandomQuestion();

}
