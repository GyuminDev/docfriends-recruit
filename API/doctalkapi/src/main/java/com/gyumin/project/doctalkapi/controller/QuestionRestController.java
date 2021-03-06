package com.gyumin.project.doctalkapi.controller;

import com.gyumin.project.doctalkapi.dto.QuestionResponseDto;
import com.gyumin.project.doctalkapi.service.QuestionService;
import com.gyumin.project.doctalkapi.util.CustomErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin
public class QuestionRestController {
    private final QuestionService questionService;

    @GetMapping(value = "/v1/questions",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QuestionResponseDto>> getQuestions() {
        List<QuestionResponseDto> questionList = questionService.findAllByOrderByCreatedDateDesc();
        if (questionList.isEmpty()) {
            return new ResponseEntity<List<QuestionResponseDto>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<QuestionResponseDto>>(questionList, HttpStatus.OK);
    }

    @GetMapping(value = "/v1/question/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getQuestionById(@PathVariable("id") Long id) {
        QuestionResponseDto question = questionService.findById(id);
        if (question == null) {
            String message = "Question with id " + id + " not found";
            return new ResponseEntity(new CustomErrorType(message), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<QuestionResponseDto>(question, HttpStatus.OK);
    }

}
