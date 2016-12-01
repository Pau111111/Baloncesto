package com.example.repository;


import com.example.domain.Equipo;
import com.example.domain.Jugador;
import com.example.domain.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by 53868459K on 14/10/2016.
 */
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    //Spring Data Queries

    List<Equipo>findByLocalidad(Localidad localidad);

}