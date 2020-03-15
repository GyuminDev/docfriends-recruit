package com.gyumin.project.doctalkapi.dto;

import com.gyumin.project.doctalkapi.domain.question.Question;
import com.gyumin.project.doctalkapi.domain.tag.Tag;
import com.gyumin.project.doctalkapi.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class QuestionListResponseDto {
    private Long id;
    private UserDto user;
    private String title;
    private String content;
    private String source;
    private LocalDateTime createdDate;
    private List<Tag> tagList;

//    @Builder
//    public QuestionListResponseDto(Question question) {
//        this.id = question.getId();
//        this.user = question.getUser();
//        this.title = question.getTitle();
//        this.content = question.getContent();
//        this.source = question.getSource();
//        this.createdDate = question.getCreatedDate();
////        this.tagList = question.getQuestionTagList();
//    }
}
