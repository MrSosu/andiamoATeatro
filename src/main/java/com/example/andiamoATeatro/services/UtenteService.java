package com.example.andiamoATeatro.services;

import com.example.andiamoATeatro.entities.Spettacolo;
import com.example.andiamoATeatro.entities.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    private Utente utente;

    public double getShowPrice(Spettacolo spettacolo) {
        return spettacolo.getPrice();
    }

}
