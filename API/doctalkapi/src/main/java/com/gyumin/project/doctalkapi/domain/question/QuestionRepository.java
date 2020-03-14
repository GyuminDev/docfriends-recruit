package com.gyumin.project.doctalkapi.domain.question;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
