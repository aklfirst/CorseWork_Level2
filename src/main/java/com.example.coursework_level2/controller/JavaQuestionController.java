package com.example.coursework_level2.controller;

import com.example.coursework_level2.domain.Question;
import com.example.coursework_level2.service.ExaminerService;
import com.example.coursework_level2.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("${application.endpoint.root}/java")

public class JavaQuestionController {


    private final QuestionService questionService;


    @GetMapping("/add")
    public Question addQuestion(@RequestParam ("QuestionText") String question, @RequestParam("QuestionAnswer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam ("QuestionText") String question, @RequestParam("QuestionAnswer") String answer) {
        return questionService.remove(new Question(question,answer));
    }


    @GetMapping("/")
    public Collection <Question> getQuestions() {
        return questionService.getAll();
    }

}
