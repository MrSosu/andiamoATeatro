package com.example.andiamoATeatro.repositories;

import com.example.andiamoATeatro.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "SELECT ticket.id FROM ticket where ticket.spettacolo = :show AND ticket.seat = :seat", nativeQuery = true)
    List<Ticket> allTicketsShow(@Param("show") long idSpettacolo, @Param("seat") long idSeat);
    @Query(value = "SELECT ticket.id FROM ticket where ticket.spettacolo = :show AND ticket.user = :user", nativeQuery = true)
    List<Ticket> allTicketsUserShow(@Param("show") long idSpettacolo, @Param("user") long idUser);

}
