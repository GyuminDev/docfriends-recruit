package com.gyumin.project.doctalkapi.service;

import com.gyumin.project.doctalkapi.domain.question.QuestionMapper;
import com.gyumin.project.doctalkapi.domain.question.QuestionRepository;
import com.gyumin.project.doctalkapi.dto.QuestionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    @Transactional
    public List<QuestionResponseDto> findAllByOrderByCreatedDateDesc() {
        return questionMapper.findAllByOrderByCreatedDateDesc();
    }

    @Transactional
    public QuestionResponseDto findById(Long id) {
        return questionMapper.findById(id);
    }

}
