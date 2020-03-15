package com.gyumin.project.doctalkapi.service;

import com.gyumin.project.doctalkapi.domain.user.User;
import com.gyumin.project.doctalkapi.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Transactional
    public User authenticate(String email, String password) {
        return userRepository.findUserByEmail(email);
    }
}
