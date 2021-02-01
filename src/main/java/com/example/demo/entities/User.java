package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity@Data@AllArgsConstructor@NoArgsConstructor@Table(name="users")
public class User {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="profileUrl")
    private String profileUrl;

}
