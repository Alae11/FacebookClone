package com.example.demo.endpoints;

import com.example.demo.dao.PublicationRepo;
import com.example.demo.entities.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@CrossOrigin("*")
public class PublicationController {
    @Autowired
    private PublicationRepo publicationRepo;

    @PostMapping("/api/post")
    public Publication postPub(@RequestBody Publication pub ){
        return publicationRepo.save(pub);
    }

    @GetMapping("api/all")
    public List<Publication> postPub( ){
        return publicationRepo.findAll();
    }

    @GetMapping("/deletePub")
    public void deleteUsers(){
        publicationRepo.deleteAll();
    }

}
