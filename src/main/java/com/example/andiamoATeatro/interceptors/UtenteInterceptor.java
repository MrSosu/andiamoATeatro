package com.example.andiamoATeatro.interceptors;

import com.example.andiamoATeatro.controllers.PostoController;
import com.example.andiamoATeatro.controllers.SpettacoloController;
import com.example.andiamoATeatro.controllers.TicketController;
import com.example.andiamoATeatro.controllers.UtenteController;
import com.example.andiamoATeatro.entities.Posto;
import com.example.andiamoATeatro.entities.Spettacolo;
import com.example.andiamoATeatro.entities.Ticket;
import com.example.andiamoATeatro.entities.Utente;
import com.example.andiamoATeatro.repositories.UtenteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

@Component
public class UtenteInterceptor implements HandlerInterceptor {

    @Autowired
    private UtenteController utenteController;

    @Autowired
    private SpettacoloController spettacoloController;

    @Autowired
    private PostoController postoController;

    @Autowired
    private TicketController ticketController;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String kindOfOperation = request.getHeader("kind");
        if (kindOfOperation.equals("purchase")) {
            /*
            1) controllare che l'utente sia registrato.

            2) controllare che lo spettacolo non sia nel passato.
            3) controllare che il posto per quello spettacolo non sia già prenotato.
            4) controllare che l'utente non abbia già prenotato 4 posti per quello spettacolo.
             */
            // 1)
            Integer idUser = Integer.parseInt(request.getHeader("user"));
            try {
                Utente u = utenteController.getUtenteById(idUser);
            }
            catch (EntityNotFoundException e) {
                System.out.println("User non trovato");
                e.printStackTrace();
                return false;
            }
            // 2)
            Integer idSpettacolo = Integer.parseInt(request.getHeader("show"));
            try {
                Spettacolo s = spettacoloController.getSpettacoloById(idSpettacolo);
            }
            catch (EntityNotFoundException e) {
                System.out.println("Spettacolo non trovato");
                e.printStackTrace();
                return false;
            }
            // 3)
            Integer idPosto = Integer.parseInt(request.getHeader("seat"));
            try {
                Posto p = postoController.getPostoById(idPosto);
            }
            catch (EntityNotFoundException e) {
                System.out.println("Posto non trovato");
                e.printStackTrace();
                return false;
            }
            // cerchiamo se esiste già un ticket riferito al posto p nello spettacolo s
            List<Ticket> ticketsShow = ticketController.ticketShow(idSpettacolo, idPosto);
            if (ticketsShow.size() > 0) {
                System.out.println("posto già prenotato");
                return false;
            }
            // 4)
            List<Ticket> ticketsUser = ticketController.ticketUserShow(idSpettacolo, idUser);
            if (ticketsUser.size() >= 4) {
                System.out.println("Hai già prenotato troppi posti!");
                return false;
            }
        }
        return true;
    }
}
