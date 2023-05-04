package com.example.andiamoATeatro.controllers;

import com.example.andiamoATeatro.entities.Ticket;
import com.example.andiamoATeatro.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
