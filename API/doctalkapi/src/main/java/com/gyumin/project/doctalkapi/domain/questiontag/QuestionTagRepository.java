package com.gyumin.project.doctalkapi.domain.questiontag;


import com.gyumin.project.doctalkapi.domain.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionTagRepository extends JpaRepository<QuestionTag, Long> {
}
