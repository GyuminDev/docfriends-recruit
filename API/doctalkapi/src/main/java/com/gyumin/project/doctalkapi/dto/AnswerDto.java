package com.gyumin.project.doctalkapi.dto;

import com.gyumin.project.doctalkapi.domain.doctor.Doctor;
import com.gyumin.project.doctalkapi.domain.question.Question;
import com.gyumin.project.doctalkapi.domain.tag.Tag;
import com.gyumin.project.doctalkapi.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class AnswerDto {
    private Long id;
    private String content;
    private DoctorDto doctor;
}
