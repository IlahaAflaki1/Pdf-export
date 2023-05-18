package com.moucdev.app.DataFixture;

import com.moucdev.app.entities.User;
import com.moucdev.app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@Slf4j
public class UserDataFixture {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void buildUsers() {
        if (userRepository.count() == 0) {
            log.info("**********************CREATE USERS************************");
            userRepository.saveAll(
                Arrays.asList(
                    new User(null,"Ilaha", "Aflaki", "mouc@gmail.com"),
                    new User(null, "Mehriban", "Jabbarli", "sow@gmail.com"),
                    new User(null, "Firat", "Lala", "joe@gmail.com"),
                    new User(null, "Uzeyir", "nanana", "leo@gmail.com")
                )
            );
        }
    }
}
