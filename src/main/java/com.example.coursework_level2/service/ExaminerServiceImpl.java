package com.example.coursework_level2.service;

import com.example.coursework_level2.domain.Question;
import com.example.coursework_level2.exceptions.TooManyQuestionsException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service

public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService = new JavaQuestionService();

    int questionsMaxQty = 5;

    @Override
    public Collection<Question> getQuestions(int amount) {

        Set<Question> questionsForUser = new HashSet<>();

        if (amount > questionsMaxQty) {
            throw new TooManyQuestionsException("Возможно запросить не более 5 вопросов!");
        }
        while (questionsForUser.size() <= amount-1) {
            questionsForUser.add(questionService.getRandomQuestion());

           }
        return questionsForUser;
    }
}
