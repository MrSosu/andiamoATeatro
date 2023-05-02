package com.example.andiamoATeatro.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Posto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Check(constraints = "fila > 0")
    @Column(nullable = false)
    private int fila;
    @Check(constraints = "number > 0")
    @Column(nullable = false)
    private int number;
    @ManyToOne
    private Sala sala;


}
