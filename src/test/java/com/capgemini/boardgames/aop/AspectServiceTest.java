package com.capgemini.boardgames.aop;

import com.capgemini.boardgames.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AspectServiceTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void shouldTest() {
        userRepository.findById(1);
    }
}