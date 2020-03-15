package com.gyumin.project.doctalkapi.domain.question;

import com.gyumin.project.doctalkapi.dto.QuestionListResponseDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QuestionMapper {
    List<QuestionListResponseDto> findAllByOrderByCreatedDateDesc();
}
