package com.gyumin.project.doctalkapi.domain.user;

import com.gyumin.project.doctalkapi.domain.BaseTimeEntity;
import com.gyumin.project.doctalkapi.domain.UserStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;



//    @Column(nullable = false, updatable = false)
//    private LocalDateTime createdDate;

    @Builder
    public User(String email, String password, UserStatus userStatus) {
        this.email = email;
        this.password = password;
        this.userStatus = userStatus;
    }
}
