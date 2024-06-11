package com.example.demo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rentas")
@Getter
@Setter
@Builder

public class Renta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Car carro;
    @ManyToOne
    private User usuario;
    private LocalDate startDate;
    private LocalDate endDate;
}
