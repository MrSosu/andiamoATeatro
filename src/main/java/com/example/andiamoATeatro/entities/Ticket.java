package com.example.andiamoATeatro.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private LocalDateTime timestamp;
    @ManyToOne
    private Posto seat;
    @ManyToOne
    private Utente user;
    @ManyToOne
    private Spettacolo spettacolo;


}
