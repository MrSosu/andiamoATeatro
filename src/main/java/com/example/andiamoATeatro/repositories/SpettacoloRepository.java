package com.example.andiamoATeatro.repositories;

import com.example.andiamoATeatro.entities.Spettacolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpettacoloRepository extends JpaRepository<Spettacolo, Long> {
}
