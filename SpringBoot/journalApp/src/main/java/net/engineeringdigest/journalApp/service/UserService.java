package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    
    @Autowired
    private  UserRepository userRepository;

   
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String userName, User userDetails) {
        User existingUser = getUser(userName);

        existingUser.setPassword(userDetails.getPassword());
        return userRepository.save(existingUser);
    }

    public void deleteUserByUsername(String userName) {
        User existingUser = getUser(userName);

        userRepository.delete(existingUser);
    }
}