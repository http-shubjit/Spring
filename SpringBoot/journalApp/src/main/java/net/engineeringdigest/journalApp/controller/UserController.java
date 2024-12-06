package net.engineeringdigest.journalApp.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userName}")
    public User getUserByUsername(@PathVariable String userName) {
       return userService.getUser(userName);
    }



    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // @PutMapping("/{userName}")
    // public ResponseEntity<User> updateUser(@PathVariable String userName, @RequestBody User userDetails) {
    //     User updatedUser = userService.updateUser(userName, userDetails);
    //     return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    // }

    // @DeleteMapping("/{userName}")
    // public ResponseEntity<Void> deleteUser(@PathVariable String userName) {
    //     userService.deleteUserByUsername(userName);
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }
}