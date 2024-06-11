package com.example.demo.repository;

import com.example.demo.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByNombreContainsIgnoreCase( String nombre);
}
