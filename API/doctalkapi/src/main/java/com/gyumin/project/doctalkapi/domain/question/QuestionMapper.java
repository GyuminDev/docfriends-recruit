package com.gyumin.project.doctalkapi.domain.question;

import com.gyumin.project.doctalkapi.dto.QuestionResponseDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QuestionMapper {
    List<QuestionResponseDto> findAllByOrderByCreatedDateDesc();
    QuestionResponseDto findById(Long id);
}
