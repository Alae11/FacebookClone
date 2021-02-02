package com.example.demo.endpoints;

import com.example.demo.dao.UserRepo;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping("/signUp")
    public Object createUser(@RequestBody User user){
        if(userRepo.findByEmail(user.getEmail())==null){
            return userRepo.save(user);
        }
        else
            return new RuntimeException("Invalid Email Adress");

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
