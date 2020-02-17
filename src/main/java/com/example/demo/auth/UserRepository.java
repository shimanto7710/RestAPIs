package com.example.demo.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM USER WHERE name = ? ", nativeQuery = true)
    User findByName(String name );

    @Query(value = "SELECT * FROM USER WHERE name = ? and pass=?", nativeQuery = true)
    User findByNameAndPass(String name, String pass);
}
