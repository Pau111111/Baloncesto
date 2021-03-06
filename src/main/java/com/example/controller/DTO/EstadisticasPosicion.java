package com.example.controller.DTO;

import com.example.domain.Posicion;

public class EstadisticasPosicion {

    private Posicion posicion;
    private Integer minCanastas;
    private Integer maxCanastas;
    private Double avgCanastas;

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Integer getMinCanastas() {
        return minCanastas;
    }

    public void setMinCanastas(Integer minCanastas) {
        this.minCanastas = minCanastas;
    }

    public Integer getMaxCanastas() {
        return maxCanastas;
    }

    public void setMaxCanastas(Integer maxCanastas) {
        this.maxCanastas = maxCanastas;
    }

    public Double getAvgCanastas() {
        return avgCanastas;
    }

    public void setAvgCanastas(Double avgCanastas) {
        this.avgCanastas = avgCanastas;
    }
}