package com.example.demo.repository;

import com.example.demo.entidades.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepository extends JpaRepository <Car,Long> {
    List<Car> findByLocationAndAvailableTrue(String location);
    List<Car> findByAvailableIsTrue(Boolean available);

}
