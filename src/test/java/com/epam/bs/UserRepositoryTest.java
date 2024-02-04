package com.epam.bs;


import com.epam.bs.repository.UserEntity;
import com.epam.bs.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;

@DataJpaTest
class UserRepositoryTest {

    private static String USER_NAME = "User test name";
    private static int USERS_NUMBER = 1;


    @Autowired
    UserRepository repository;

    @Test
    void shouldSaveOnly1UserToDB() {
        UserEntity user = new UserEntity();
        user.setName(USER_NAME);
        repository.save(user);

        List<UserEntity> allUsers = repository.findAll();

        assertEquals(USERS_NUMBER, allUsers.size());
        assertEquals(USER_NAME, allUsers.get(0).getName());

    }

}