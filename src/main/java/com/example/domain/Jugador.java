package com.example.domain;

import org.apache.tomcat.jni.Local;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by 53868459K on 14/10/2016.
 */
@Entity
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private LocalDate fecha_nacimiento;
    private Integer canastas;
    private Integer asistencias;
    private Integer rebotes;
    private Posicion posicion;

    public Jugador(String pablo, LocalDate of, int canastas, int asistencias, int rebotes, String alero) {
    }

    public Jugador(String nombre, LocalDate fecha_nacimiento, Integer canastas, Integer asistencias, Integer rebotes, Posicion posicion) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.canastas = canastas;
        this.asistencias = asistencias;
        this.rebotes = rebotes;
        this.posicion = posicion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getCanastas() {
        return canastas;
    }

    public void setCanastas(Integer canastas) {
        this.canastas = canastas;
    }

    public Integer getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Integer asistencias) {
        this.asistencias = asistencias;
    }

    public Integer getRebotes() {
        return rebotes;
    }

    public void setRebotes(Integer rebotes) {
        this.rebotes = rebotes;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", canastas=" + canastas +
                ", asistencias=" + asistencias +
                ", rebotes=" + rebotes +
                ", posicion='" + posicion + '\'' +
                '}';
    }


}

/*
package com.example.domain;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand;
    private String model;
    private Integer yearOfFab;
    private String plateNumber;
    private double price;


    public Car(long id, String brand, String model, Integer yearOfFab, String plateNumber, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfFab = yearOfFab;
        this.plateNumber = plateNumber;
        this.price=price;
    }

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYearOfFab() {
        return yearOfFab;
    }

    public void setYearOfFab(Integer yearOfFab) {
        this.yearOfFab = yearOfFab;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        plateNumber = plateNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearOfFab=" + yearOfFab +
                ", plateNumber='" + plateNumber + '\'' +
                ", price=" + price +
                '}'+System.lineSeparator();
    }

    public int compareTo(Car anotherCar){

        // System.out.println("Comparing the following two cars: ");
        // System.out.println(this);
        // System.out.println(anotherCar);
        return this.plateNumber.compareTo(anotherCar.plateNumber);
    }

}

/*class CarComparatorByYear implements Comparator<Car>
{
    @Override
    public int compare(Car car, Car anotherCar)
    {
        if(car.getYearOfFab() > anotherCar.getYearOfFab())
        {
            return 1;
        }
        else if (car.getYearOfFab() < anotherCar.getYearOfFab())
        {
            return -1;
        }
        else return 0;
    }

}*/