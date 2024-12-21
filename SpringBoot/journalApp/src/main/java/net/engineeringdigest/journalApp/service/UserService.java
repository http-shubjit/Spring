package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    
    @Autowired
    private UserRepository userRepository;
    

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
   
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User save(User user) {
         user.setPassword(passwordEncoder.encode(user.getPassword()));
            return  userRepository.save(user);                   
        }

    
}