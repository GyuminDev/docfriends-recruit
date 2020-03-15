package com.gyumin.project.doctalkapi.domain.questiontag;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.gyumin.project.doctalkapi.domain.BaseTimeEntity;
import com.gyumin.project.doctalkapi.domain.question.Question;
import com.gyumin.project.doctalkapi.domain.tag.Tag;
import com.gyumin.project.doctalkapi.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class QuestionTag extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @Builder
    public QuestionTag(Question question, Tag tag) {
        this.question = question;
        this.tag = tag;
    }
}
