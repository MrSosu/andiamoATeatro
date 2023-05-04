package com.example.andiamoATeatro.controllers;

import com.example.andiamoATeatro.entities.Sede;
import com.example.andiamoATeatro.repositories.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/sede")
public class SedeController {

    @Autowired
    private SedeRepository sedeRepository;

    @GetMapping("/{id}")
    public Sede getSedeById(@PathVariable long id) {
        return sedeRepository.getReferenceById(id);
    }

    @GetMapping("/all")
    public List<Sede> getAllSedi() {
        return sedeRepository.findAll();
    }

    @PostMapping("/create")
    public Sede createSede(@RequestBody Sede sede) {
        return sedeRepository.saveAndFlush(sede);
    }

    @DeleteMapping("/{id}")
    public void deleteSedeById(@PathVariable long id) {
        sedeRepository.deleteById(id);
    }

    @PutMapping("/update")
    public Sede updateSede(@RequestBody Sede sede) {
        return sedeRepository.saveAndFlush(sede);
    }

}
