package com.example.demo.dao;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    String query_1="select * from users where users.email=:email and users.password=:password";
    @Query(value = query_1,nativeQuery = true)
    public User findByEmailAndPass(@Param("email") String email,@Param("password") String password);



    String query_2="select * from users where users.email=:email ";
    @Query(value = query_2,nativeQuery = true)
    public User findByEmail(@Param("email") String email);

}
