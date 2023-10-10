package com.facu.dummy;

import com.facu.dummy.entities.*;
import com.facu.dummy.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class DummyApplication {
	@Autowired
	private PersonaRepository personaRepository;
	public static void main(String[] args) {

		SpringApplication.run(DummyApplication.class, args);
		System.out.println("Estoy andando");
	}
}
