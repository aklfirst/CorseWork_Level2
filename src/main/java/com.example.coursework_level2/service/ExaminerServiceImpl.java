package com.example.coursework_level2.service;

import com.example.coursework_level2.domain.Question;
import com.example.coursework_level2.exceptions.TooManyQuestionsException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service

public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {

        int totalQuestionsInBase = questionService.getAll().size();

        if (amount > totalQuestionsInBase) {
            throw new TooManyQuestionsException("Запрошено слишком много вопросов!");
        }
        Set<Question> questionsForUser = new HashSet<>();

        while (questionsForUser.size() <= amount-1) {
            questionsForUser.add(questionService.getRandomQuestion());

           }
        return questionsForUser;
    }
}
