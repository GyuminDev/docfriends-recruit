package com.gyumin.project.doctalkapi.domain.tag;

import com.gyumin.project.doctalkapi.domain.BaseTimeEntity;
import com.gyumin.project.doctalkapi.domain.questiontag.QuestionTag;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Tag extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "tag")
    private List<QuestionTag> questionTagList = new ArrayList<>();
}
