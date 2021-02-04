package com.example.demo.endpoints;

import com.example.demo.dao.UserRepo;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @GetMapping("user/{id}")
    public User getUser(@PathVariable("id") Long id){
        return userRepo.findById(id).get();
    }

    @PostMapping("/signUp")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if(userRepo.findByEmail(user.getEmail())==null){
            return new ResponseEntity<>(userRepo.save(user),HttpStatus.OK);
        }
        else
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Email Adress");

    }

    @PostMapping("/signIn")
    public User signIn(@RequestBody User user){
        return userRepo.findByEmailAndPass(user.getEmail(),user.getPassword());
    }
    @GetMapping("/delete")
    public void deleteUsers(){
        userRepo.deleteAll();
    }
}
