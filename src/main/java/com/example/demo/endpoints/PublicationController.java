package com.example.demo.endpoints;

import com.example.demo.dao.PublicationRepo;
import com.example.demo.entities.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@CrossOrigin("*")@RequestMapping("/api")
public class PublicationController {
    @Autowired
    private PublicationRepo publicationRepo;

    @PostMapping("/post")
    public Publication postPub(@RequestBody Publication pub ){
        return publicationRepo.save(pub);
    }

    @GetMapping("/all")
    public List<Publication> postPub( ){
        return publicationRepo.findAll();
    }

    @GetMapping("/deletePub/{id}")
    public void deleteUsers(@PathVariable("id") Long id){
        publicationRepo.deleteById(id);
    }

}
