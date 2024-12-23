package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UserService {

    
    @Autowired
    private UserRepository userRepository;
    

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
   
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public boolean saveNewUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            log.error("Error while saving new user", e);
            
            return false;
        }
    }

    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userRepository.save(user);
    }
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

   
    
   

    
}