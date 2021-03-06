package com.example.controller;

import com.example.controller.DTO.EstadisticasPosicion;
import com.example.controller.Util.HeaderUtil;
import com.example.domain.Jugador;
import com.example.domain.Posicion;
import com.example.repository.JugadorRepository;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 53868459K on 24/10/2016.
 */

@RestController
@RequestMapping ("/jugadores")
public class PlayerController {

    @Autowired
    private JugadorRepository jugadorRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Jugador> createPlayer(@RequestBody Jugador jugador) throws URISyntaxException {
        if (jugador.getId() != null) {
            return ResponseEntity.
                    badRequest().
                    headers(
                            HeaderUtil.
                                    createFailureAlert("player", "idexists", "A new player cannot already have an ID")).body(null);
        }
        Jugador result = jugadorRepository.save(jugador);
        return ResponseEntity.created(new URI("/jugadores/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert("jugador", result.getId().toString()))
                .body(result);
    }


    //@PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
   // public Jugador createJugador(@RequestBody Jugador jugador) {
     //   return jugadorRepository.save(jugador);
    //}

    @PutMapping
    public Jugador updateJugador(@RequestBody Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @GetMapping
    public List<Jugador> findAll() {
        return jugadorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Jugador findById(@PathVariable Long id) {
        Jugador jugador = jugadorRepository.findOne(id);
        return jugador;
    }

    @GetMapping("/findByCanastasGreaterThanEqual/{num}")
   public List<Jugador> findByCanastasGreaterThanEqual(@PathVariable Integer num) {
       return jugadorRepository.findByCanastasGreaterThanEqual(num);
    }

    //no funciona
    @GetMapping("/findByCanastasBetween/{min}/and/{max}")
    public List<Jugador> findByCanastasBetween(@PathVariable Integer min, @PathVariable Integer max) {
        return jugadorRepository.findByCanastasBetween(min, max);
    }

    @GetMapping("/JugadoresSortCanastas")
    public List<Object[]> JugadoresSortCanastas() {
        return jugadorRepository.JugadoresSortCanastas();
    }

    @GetMapping("/JugadoresGroupPosition")
    public Map<Posicion, Collection<Jugador>> JugadoresGroupPosition(){
        List<Jugador> jugadores = jugadorRepository.findAll();

        ListMultimap<Posicion, Jugador> playerMultiMap = ArrayListMultimap.create();

        jugadores.forEach(jugador -> playerMultiMap.put(jugador.getPosicion(), jugador));


        System.out.println(playerMultiMap.get(Posicion.alapivot));

        return playerMultiMap.asMap();
    }

    @GetMapping("/JugadoresGroupPositionPlus")
    public Map<Posicion, EstadisticasPosicion> JugadoresGroupPositionPlus(){

        List<Object[]> estadisticasPosicions = jugadorRepository.JugadoresGroupPositionPlus();

        Map<Posicion, EstadisticasPosicion> estadisticasPosicionMap = new HashMap<>();

        estadisticasPosicions.forEach(estadisticasPosicion -> {

                    EstadisticasPosicion aux = new EstadisticasPosicion();
                    aux.setPosicion((Posicion)estadisticasPosicion[0]);
                    aux.setMinCanastas((Integer)estadisticasPosicion[1]);
                    aux.setMaxCanastas((Integer)estadisticasPosicion[2]);
                    aux.setAvgCanastas((Double) estadisticasPosicion[3]);

                    estadisticasPosicionMap.put(aux.getPosicion(), aux);

                });

        return estadisticasPosicionMap;
    }

    @DeleteMapping("/{id}")
    public void deleteJugador(@PathVariable Long id) {
        jugadorRepository.delete(id);
    }



//    @Autowired
//    private JugadorRepository jugadorRepository;
//
//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public Jugador createJugador(@RequestBody Jugador jugador) {
//        return jugadorRepository.save(jugador);
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    //find es algo que no puc tocar pero All puc canviar-ho per qualsvol paraula
//    public List<Jugador> findAll() {
//        return jugadorRepository.findAll();
//    }
//
//    @RequestMapping(value = "/{id}",
//            method = RequestMethod.GET)
//    public Jugador findById(@PathVariable Long id) {
//        Jugador jugador = jugadorRepository.findOne(id);
//        return jugador;
//    }
//
//    @RequestMapping(value = "/byCanastas/{num}",
//            method = RequestMethod.GET)
//    public List<Jugador> findByCanastasGreaterThan(@PathVariable Integer num) {
//        return jugadorRepository.findByCanastasGreaterThanEqual(num);
//    }
}


