package com.example.coursework_level2.controller;

import com.example.coursework_level2.domain.Question;
import com.example.coursework_level2.service.ExaminerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequiredArgsConstructor
@RequestMapping("/exam")

public class ExamController {

    private final ExaminerService examinerService;

    @GetMapping("/get/{amount}")

    public Collection<Question> getQuestions(@PathVariable Integer amount) {
        return examinerService.getQuestions(amount);
    }


}
