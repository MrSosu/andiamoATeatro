package com.example.andiamoATeatro.repositories;

import com.example.andiamoATeatro.entities.Posto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostoRepository extends JpaRepository<Posto, Long> {

}
