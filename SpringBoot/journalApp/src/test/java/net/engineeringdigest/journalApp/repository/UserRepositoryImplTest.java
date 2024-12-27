package net.engineeringdigest.journalApp.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.engineeringdigest.journalApp.entity.User;

@SpringBootTest
public class UserRepositoryImplTest {
   
    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @Test
    void getUserForSATest() {
        List<User> user = userRepositoryImpl.getUserForSA();
        assertNotNull(user);
assertFalse(user.isEmpty(), "Expected at least one user but found none.");
    }
    

}
