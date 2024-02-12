package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value="/vistausuario", method=RequestMethod.GET)
	//@GetMapping(value="vistausuario")	// De esta forma se da por hecho que es un GET
	public String metodo(Model model) {
		String cadenadetexto="Esto es un mensaje del controlador. Prueba segundo commit";
		model.addAttribute("mensaje", cadenadetexto);	// Grabamos mensaje con el contenido de cadenadetexto
		return "vista";
	}
}
