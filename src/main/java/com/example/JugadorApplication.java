package com.example;

import com.example.service.JugadorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JugadorApplication {

	public static void main(String[] args) {
		 ConfigurableApplicationContext context = SpringApplication.run(JugadorApplication.class, args);

		JugadorService jugadorService=context.getBean(JugadorService.class);

		jugadorService.testJugadores();
	}
}

/*
package com.example;

import com.example.service.CarService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CarApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(CarApplication.class, args);

		CarService carService=context.getBean(CarService.class);

		carService.testCars();

	}
}

 */