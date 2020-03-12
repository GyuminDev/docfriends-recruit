package com.gyumin.project.doctalkapi.domain.answer;

import com.gyumin.project.doctalkapi.domain.BaseTimeEntity;
import com.gyumin.project.doctalkapi.domain.question.Question;
import lombok.Builder;

import javax.persistence.*;

public class Answer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    private String description;

    @Builder
    public Answer(Question question, String description) {
        this.question = question;
        this.description = description;
    }
}
