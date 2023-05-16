package com.example.andiamoATeatro.controllers;

import com.example.andiamoATeatro.entities.Posto;
import com.example.andiamoATeatro.entities.Spettacolo;
import com.example.andiamoATeatro.entities.Ticket;
import com.example.andiamoATeatro.entities.Utente;
import com.example.andiamoATeatro.repositories.PostoRepository;
import com.example.andiamoATeatro.repositories.SpettacoloRepository;
import com.example.andiamoATeatro.repositories.TicketRepository;
import com.example.andiamoATeatro.repositories.UtenteRepository;
import com.example.andiamoATeatro.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private TicketController ticketController;
    @Autowired
    private PostoController postoController;
    @Autowired
    private SpettacoloController spettacoloController;
    @Autowired
    private UtenteService utenteService;

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

    /*
    Gli utenti registrati devono poter prenotare dei posti disponibili in uno spettacolo, e il sistema
     deve calcolare il prezzo da pagare per l’utente.
     */
    @PostMapping("/purchase")
    public double buyTicket(@RequestHeader("user") long idUser, @RequestHeader("seat") long idSeat, @RequestHeader("show") long idShow) {
        Ticket ticket = new Ticket();
        ticket.setTimestamp(LocalDateTime.now());
        Utente u = getUtenteById(idUser);
        Spettacolo s = spettacoloController.getSpettacoloById(idShow);
        Posto p = postoController.getPostoById(idSeat);
        ticket.setUser(u);
        ticket.setSpettacolo(s);
        ticket.setSeat(p);
        ticketController.createTicket(ticket);
        return utenteService.getShowPrice(s);
    }

}
