package com.example.demo.dao;

import com.example.demo.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepo extends JpaRepository<Publication, Long> {
}
