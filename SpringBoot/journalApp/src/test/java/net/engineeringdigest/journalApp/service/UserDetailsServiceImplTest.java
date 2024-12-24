// package net.engineeringdigest.journalApp.service;

// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.mockito.Mockito.when;

// import java.util.ArrayList;

// import org.junit.jupiter.api.Test;
// import org.mockito.ArgumentMatcher;
// import org.mockito.ArgumentMatchers;
// import org.mockito.Mock;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.security.core.userdetails.UserDetails;

// import net.engineeringdigest.journalApp.entity.User;
// import net.engineeringdigest.journalApp.repository.UserRepository;

// //Learn Mokito

// @SpringBootTest 

// here we use @SpringBootTest for starting the springboot application context which means it  
// willstart the springboot application and load all the beans and configurations for the test 
 
// public class UserDetailsServiceImplTest {


//     @Autowired
//     UserDetailsServiceImpl uServiceImpl;

//     @MockBean
//     private UserRepository userRepository;
    

//     @Test
//     void loadUserByUsernameTest() {

//         when(userRepository.findByUserName(ArgumentMatchers.anyString()))
//                 .thenReturn(User.builder().userName("ram").password("inrinrick").roles(new ArrayList<>()).build());

//         UserDetails user = uServiceImpl.loadUserByUsername("ram");
//         assertNotNull(user);

//     }
    
// }







//** Without Startig Springbbot Application context  we cann test by using @Mock and @InjectMock*/


// Let’s illustrate this with an example:
// Class Definition:
// java
// public class UserDetailsServiceImpl {
//     private UserRepository userRepository;

//     public UserDetailsServiceImpl(UserRepository userRepository) {
//         this.userRepository = userRepository; // This is where the injection happens
//     }

//     public UserDetails loadUserByUsername(String username) {
//         return userRepository.findByUserName(username); // Uses the injected repository
//     }
// }

package net.engineeringdigest.journalApp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;

//here we not use @SpringBootTest for starting the springboot application context as above

public class UserDetailsServiceImplTest {

@InjectMocks
UserDetailsServiceImpl uServiceImpl;

@Mock
private UserRepository userRepository;
@BeforeEach
void setUp() {
    MockitoAnnotations.initMocks(this);
}

@Test
void loadUserByUsernameTest() {

when(userRepository.findByUserName(ArgumentMatchers.anyString()))
.thenReturn(User.builder().userName("ram").password("inrinrick").roles(new
ArrayList<>()).build());

UserDetails user = uServiceImpl.loadUserByUsername("ram");
assertNotNull(user);

}

}
