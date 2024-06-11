package com.example.demo.repository;

import com.example.demo.entidades.Renta;
import com.example.demo.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RentaRepository extends JpaRepository <Renta, Long> {
    List<Renta> findByUser (User usuario);
}
