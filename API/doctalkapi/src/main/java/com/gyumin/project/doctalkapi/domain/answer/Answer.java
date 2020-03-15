package com.gyumin.project.doctalkapi.domain.answer;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.gyumin.project.doctalkapi.domain.BaseTimeEntity;
import com.gyumin.project.doctalkapi.domain.doctor.Doctor;
import com.gyumin.project.doctalkapi.domain.question.Question;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Answer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;


    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public Answer(Question question, String content) {
        this.question = question;
        this.content = content;
    }
}
