package com.example.firstcrud.controllers;

import com.example.firstcrud.entities.User;
import com.example.firstcrud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll(){
      List<User> findAllUsers = repository.findAll();
      return  findAllUsers;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        User findUserById = repository.findById(id).orElse(null);
        if (findUserById == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return  ResponseEntity.ok(findUserById);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        User createNewUser = repository.save(user);
        return  createNewUser;
    }

    @PutMapping(value = "/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        User existingUser = repository.findById(id).orElse(null);
        if(existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setDerpartment(user.getDerpartment());
            return repository.save(existingUser);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        repository.deleteById(id);
    }

}
