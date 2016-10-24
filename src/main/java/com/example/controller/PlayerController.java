package com.example.controller;

import com.example.domain.Jugador;
import com.example.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by 53868459K on 24/10/2016.
 */

@RestController
@RequestMapping ("/jugadores")
public class PlayerController {

    @Autowired
    private JugadorRepository jugadorRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Jugador createJugador(@RequestBody Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @RequestMapping(method = RequestMethod.GET)
    //find es algo que no puc tocar pero All puc canviar-ho per qualsvol paraula
    public List<Jugador> findAll(){
        return jugadorRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Jugador> findByAsistenciasGreaterThan(){
        return
    }

}


