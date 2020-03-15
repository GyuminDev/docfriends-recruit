package com.gyumin.project.doctalkapi.controller;

import com.gyumin.project.doctalkapi.dto.QuestionListResponseDto;
import com.gyumin.project.doctalkapi.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class QuestionRestController {
    private final QuestionService questionService;


    @GetMapping(value = "v1/questions", produces = "application/json")
    public ResponseEntity getQuestions() {
        List<QuestionListResponseDto> questionList = questionService.findAllByOrderByCreatedDateDesc();
        if (questionList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<QuestionListResponseDto>>(questionList, HttpStatus.OK);
    }

}
