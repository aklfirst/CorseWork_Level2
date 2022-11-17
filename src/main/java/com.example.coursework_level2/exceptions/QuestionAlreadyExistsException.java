package com.example.coursework_level2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class QuestionAlreadyExistsException extends RuntimeException {

    public QuestionAlreadyExistsException(String message) {
        super(message);
    }
}
