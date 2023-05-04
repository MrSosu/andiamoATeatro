package com.example.andiamoATeatro.controllers;

import com.example.andiamoATeatro.entities.Utente;
import com.example.andiamoATeatro.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    private UtenteRepository utenteRepository;

    @GetMapping("/{id}")
    public Utente getUtenteById(@PathVariable long id) {
        return utenteRepository.getReferenceById(id);
    }

    @GetMapping("/all")
    public List<Utente> getAllUtenti() {
        return utenteRepository.findAll();
    }

    @PostMapping("/create")
    public Utente createUtente(@RequestBody Utente utente) {
        return utenteRepository.saveAndFlush(utente);
    }

    @DeleteMapping("/{id}")
    public void deleteUtenteById(@PathVariable long id) {
        utenteRepository.deleteById(id);
    }

    @PutMapping("/update")
    public Utente updateUtente(@RequestBody Utente utente) {
        return utenteRepository.saveAndFlush(utente);
    }

}
