package com.gyumin.project.doctalkapi.domain.question;

import com.gyumin.project.doctalkapi.domain.BaseTimeEntity;
import com.gyumin.project.doctalkapi.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Question extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private String tag;

    @Column(nullable = false)
    private String source;

    @Builder
    public Question(User user, String title, String description, String tag, String source) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.tag = tag;
        this.source = source;
    }
}
