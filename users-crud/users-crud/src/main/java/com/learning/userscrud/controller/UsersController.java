package com.learning.userscrud.controller;

import com.learning.userscrud.exception.ResourceNotFoundException;
import com.learning.userscrud.model.User;
import com.learning.userscrud.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    private List<User> getAllUsers() {
        return  usersRepository.findAll();
    }

    @GetMapping("{id}")
    private ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = usersRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User not exist"));
        return ResponseEntity.ok(user);
    }

    @PostMapping
    private User createUser(@RequestBody User user) {
        return  usersRepository.save(user);
    }



    @PutMapping("{id}")
    private ResponseEntity<User>  updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updateUser = usersRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User not exist"));
        if (userDetails.getFirstName() != null) {
            updateUser.setLastName(userDetails.getLastName());
        }
        if(userDetails.getLastName() != null) {
            updateUser.setFirstName(userDetails.getFirstName());
        }
        usersRepository.save(updateUser);
        return  ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        User user = usersRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User not exist"));
        usersRepository.delete(user);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
