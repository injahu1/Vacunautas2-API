package com.misiontic.vacunautas2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class miController {
	
	@GetMapping(value="/metodo-saludar")
	public String saludar() {
		return "hola como estas el dia de hoy.";
	}
}