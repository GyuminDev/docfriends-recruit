package com.gyumin.project.doctalkapi.service;

import com.gyumin.project.doctalkapi.domain.question.Question;
import com.gyumin.project.doctalkapi.domain.question.QuestionMapper;
import com.gyumin.project.doctalkapi.domain.question.QuestionRepository;
import com.gyumin.project.doctalkapi.dto.QuestionListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    @Transactional
    public List<QuestionListResponseDto> findAllByOrderByCreatedDateDesc() {
        return questionMapper.findAllByOrderByCreatedDateDesc();
    }

}
