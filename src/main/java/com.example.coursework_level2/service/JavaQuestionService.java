package com.example.coursework_level2.service;

import com.example.coursework_level2.domain.Question;
import com.example.coursework_level2.exceptions.QuestionAlreadyExistsException;
import com.example.coursework_level2.exceptions.QuestionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

import static java.util.Map.entry;

@Service

public class JavaQuestionService implements QuestionService  {

    Map<Integer, Question> frozenQuestionsList = Map.ofEntries(
            entry(1, new Question("Какие условные операторы в Java вы знаете?", "==; >; <; >=; <=; !=; if_else")),
            entry(2, new Question("Какие циклы в Java вы знаете?", "while; do while; for")),
            entry(3, new Question("Методы каких типов бывают?", "статические и нестатические")),
            entry(4, new Question("Приведите примеры статического метода", "Arrays.toString()")),
            entry(5, new Question("Приведите примеры нестатического метода", "toUpperCase")),
            entry(6, new Question("Назовите типы переменных", "Примитивный и ссылочный")),
            entry(7, new Question("Что такое переменные примитивного типа?", "Переменные, которые хранят в себе данные")),
            entry(8, new Question("Что такое переменные ссылочного типа?", "Обьекты, хранящие не значения, а ссылки на данные из области памяти")),
            entry(9, new Question("Приведите пример переменной примитивного типа", "Integer, long, boolean и т.д.")),
            entry(10, new Question("Приведите пример переменной ссылочного типа", "массивы, строки, листы")),
            entry(11, new Question("Что такое инкапсуляция?", "Один из 3-х принципов ООП подразумевает разграничение доступа к данным и возможностям классов и объектов")),
            entry(12, new Question("Что такое коллекции?", "это способы хранения обьектов, альтернативных массивам, которые дают иные, более широкие возможности для их вызова, обработки и изменения."))
    );

    public HashMap<Integer,Question> modifiableQuestionsList = new HashMap<>(frozenQuestionsList);

    @Override
    public Question add(String question, String answer) {
        Question questionToAdd = new Question(question, answer);
        if (modifiableQuestionsList.containsValue(questionToAdd)) {
            throw new QuestionAlreadyExistsException("Такой вопрос уже есть в базе!");
        }
        modifiableQuestionsList.put(getHighestKey() + 1, questionToAdd);
        return questionToAdd;
    }

    @Override
    public Question find(Question question) {
        if (!modifiableQuestionsList.containsValue(question)) {
            throw new QuestionNotFoundException("Такого вопроса нет в базе!");
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        return modifiableQuestionsList.remove(findKeyByQuestion(find(question)));
        }

    @Override
    public Collection <Question> getAll() {
        return new ArrayList<>(modifiableQuestionsList.values());
        }

    @Override
    public Question getRandomQuestion() {
        List<Integer> keysFromMap = new ArrayList<Integer>(modifiableQuestionsList.keySet());
        Random random = new Random();
        return modifiableQuestionsList.get(keysFromMap.get(random.nextInt(keysFromMap.size())));
    }



    public Integer getHighestKey() {
        Set<Map.Entry<Integer, Question>> keysTheHighest = modifiableQuestionsList.entrySet();
        Integer key1 = null;
        for (Map.Entry<Integer, Question> entry : keysTheHighest) {
            key1 = entry.getKey();
            if (key1 <= keysTheHighest.size()) {
                key1 = keysTheHighest.size();
            }
        }
        return key1;
    }

    public Integer findKeyByQuestion(Question question) {
        Set<Map.Entry<Integer, Question>> keysToSearch = modifiableQuestionsList.entrySet();
        Integer key1 = null;
        for (Map.Entry<Integer, Question> search : keysToSearch) {

            if (question.equals(search.getValue())) {
                key1 = search.getKey();
            }
        }
        return key1;
    }

}




