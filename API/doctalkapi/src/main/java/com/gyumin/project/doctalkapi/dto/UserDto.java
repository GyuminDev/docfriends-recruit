package com.gyumin.project.doctalkapi.dto;

import com.gyumin.project.doctalkapi.domain.UserStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {
    private Long id;
    private String email;
    private UserStatus userStatus;
}
