package com.gyumin.project.doctalkapi.domain.user;

import com.gyumin.project.doctalkapi.domain.UserStatus;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @After
    public void cleanUp() throws Exception {
        userRepository.deleteAll();
    }

    @Test
    public void findAll() {
        String name = "test";
        String password = "123456";
        UserStatus userStatus = UserStatus.ACTIVE;

        userRepository.save(User.builder()
                .name(name)
                .password(password)
                .userStatus(userStatus)
                .build());

        List<User> userList = userRepository.findAll();

        User user = userList.get(0);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getPassword()).isEqualTo(password);
        assertThat(user.getUserStatus()).isEqualTo(userStatus);
    }
}