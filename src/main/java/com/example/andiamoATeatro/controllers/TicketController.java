package com.example.andiamoATeatro.controllers;

import com.example.andiamoATeatro.entities.Ticket;
import com.example.andiamoATeatro.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable long id) {
        return ticketRepository.getReferenceById(id);
    }

    @GetMapping("/all")
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public List<Ticket> ticketShow(long idSpettacolo, long idSeat) {
        return ticketRepository.allTicketsShow(idSpettacolo, idSeat);
    }
    public List<Ticket> ticketUserShow(long idSpettacolo, long idUser) {
        return ticketRepository.allTicketsUserShow(idSpettacolo, idUser);
    }

    @PostMapping("/create")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketRepository.saveAndFlush(ticket);
    }

    @DeleteMapping("/{id}")
    public void deleteTicketById(@PathVariable long id) {
        ticketRepository.deleteById(id);
    }

    @PutMapping("/update")
    public Ticket updateTicket(@RequestBody Ticket ticket) {
        return ticketRepository.saveAndFlush(ticket);
    }



}
