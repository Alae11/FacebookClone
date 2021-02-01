package com.example.demo.endpoints;

import com.example.demo.dao.PublicationRepo;
import com.example.demo.entities.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
}
