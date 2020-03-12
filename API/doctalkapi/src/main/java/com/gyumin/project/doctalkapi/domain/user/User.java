package com.gyumin.project.doctalkapi.domain.user;

import com.gyumin.project.doctalkapi.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;

    @Builder
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
