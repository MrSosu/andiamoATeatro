package com.example.andiamoATeatro.controllers;

import com.example.andiamoATeatro.entities.Posto;
import com.example.andiamoATeatro.repositories.PostoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/posto")
public class PostoController {

    @Autowired
    private PostoRepository postoRepository;

    @GetMapping("/{id}")
    public Posto getPostoById(@PathVariable long id) {
        return postoRepository.getReferenceById(id);
    }

    @GetMapping("/all")
    public List<Posto> getAllPosti() {
        return postoRepository.findAll();
    }

    @PostMapping("/create")
    public Posto createPosto(@RequestBody Posto posto) {
        return postoRepository.saveAndFlush(posto);
    }

    @DeleteMapping("/{id}")
    public void deletePostoById(@PathVariable long id) {
        postoRepository.deleteById(id);
    }

    @PutMapping("/update")
    public Posto updatePosto(@RequestBody Posto posto) {
        return postoRepository.saveAndFlush(posto);
    }
}
