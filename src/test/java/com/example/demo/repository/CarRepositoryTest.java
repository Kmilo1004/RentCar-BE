// src/test/java/com/example/demo/repository/CarRepositoryTest.java
package com.example.demo.repository;


import com.example.demo.AbstractIntegrationDBTest;
import com.example.demo.entidades.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")


class CarRepositoryTest extends AbstractIntegrationDBTest {

    @Autowired
    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
        // Limpiar la base de datos antes de cada prueba
        carRepository.deleteAll();
    }


    // Añadir datos de prueba
    Car car1 = Car.builder()
            .Location("Location1")
            .Available(true)
            .build();
        carRepository.save(car1);

    Car car2 = Car.builder()
            .setLocation("Location1")
            .setAvailable(false)
            .build();
        carRepository.save(car2);

    Car car3 = Car.builder()
            .setLocation("Location2")
            .setAvailable(true)
            .build();
        carRepository.save(car3);


    @Test
    void findByLocationAndAvailableTrue() {
        List<Car> cars = carRepository.findByLocationAndAvailableTrue("Location1");
        assertEquals(1, cars.size());
        assertTrue(cars.get(0).isAvailable());
        assertEquals("Location1", cars.get(0).getLocation());
    }

    @Test
    void findByAvailableIsTrue() {
        List<Car> cars = carRepository.findByAvailableIsTrue();
        assertEquals(2, cars.size());
        assertTrue(cars.stream().allMatch(Car::isAvailable));
    }
}
