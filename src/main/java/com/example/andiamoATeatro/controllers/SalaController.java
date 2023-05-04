package com.example.andiamoATeatro.controllers;

import com.example.andiamoATeatro.entities.Sala;
import com.example.andiamoATeatro.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/sala")
public class SalaController {

    @Autowired
    private SalaRepository salaRepository;

    @GetMapping("/{id}")
    public Sala getSalaById(@PathVariable long id) {
        return salaRepository.getReferenceById(id);
    }

    @GetMapping("/all")
    public List<Sala> getAllSale() {
        return salaRepository.findAll();
    }

    @PostMapping("/create")
    public Sala createSala(@RequestBody Sala sala) {
        return salaRepository.saveAndFlush(sala);
    }

    @DeleteMapping("/{id}")
    public void deleteSalaById(@PathVariable long id) {
        salaRepository.deleteById(id);
    }

    @PutMapping("/update")
    public Sala updateSala(@RequestBody Sala sala) {
        return salaRepository.saveAndFlush(sala);
    }

}
