package com.example.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data@Entity@Table(name="Publication")@NoArgsConstructor@AllArgsConstructor
public class Publication {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String imageUrl;
    private Timestamp timesstamp;
    private String message;
}
