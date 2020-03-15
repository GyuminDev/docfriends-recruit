package com.gyumin.project.doctalkapi.domain.user;

import com.gyumin.project.doctalkapi.domain.UserStatus;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void findAll() {
        String email = "test";
        String password = "123456";
        UserStatus userStatus = UserStatus.ACTIVE;

        userRepository.save(User.builder()
                .email(email)
                .password(password)
                .userStatus(userStatus)
                .build());

        List<User> userList = userRepository.findAll();

        User user = userList.get(1);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getPassword()).isEqualTo(password);
        assertThat(user.getUserStatus()).isEqualTo(userStatus);
    }


    @Test
    public void timeAuditing() {
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        userRepository.save(User.builder()
                .email("pleasure082@gmail.com")
                .password("test1234")
                .userStatus(UserStatus.ACTIVE)
                .build());

        List<User> userList = userRepository.findAll();

        User user = userList.get(0);
        System.out.println(">>>>>>>>> createDate=" + user.getCreatedDate());

        assertThat(user.getCreatedDate()).isAfter(now);
    }
}