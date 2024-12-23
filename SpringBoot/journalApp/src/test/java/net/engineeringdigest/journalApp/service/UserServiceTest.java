package net.engineeringdigest.journalApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.engineeringdigest.journalApp.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {
    
    @Autowired
    private UserService userService;

    // @Test
    // @Disabled
    // public void testfindByUserName() {
    //     assertNotNull(userRepository.findByUserName("shuh"));
    // }



    @ParameterizedTest

    @CsvSource({"shubh","Ram"})

    // @ValueSource(strings = {"shubh","Ram","raka"})

    // @EnumSource(names  = { "shubh", "Ram", "raka" })

    public void testfindByUserNamebyParameter(String name) {
        assertNotNull(userService.findByUserName(name),"failed for "+name);
    }


}
