package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	
	@GetMapping(value="/vistausuario")
	//@GetMapping(value="vistausuario")	// De esta forma se da por hecho que es un GET
	public String metodo(Model model) {
		String cadenadetexto="Esto es un mensaje del controlador. Prueba segundo commit";
		model.addAttribute("mensaje", cadenadetexto);	// Grabamos mensaje con el contenido de cadenadetexto
		return "vista";
	}
	
	//@PostMapping(value="/datosusuario")
	//public String metodo(HttpServletRequest req) {
	//	String usuario = req.getParameter("usuario");
	//	String email = req.getParameter("email");
	//	String nombre = req.getParameter("nombre");
	//	String apellidos = req.getParameter("apellidos");
	//	System.out.println(usuario + ", " + email + ", " + nombre + ", " + apellidos);
	//	return "formulario";
	//}
	
	@PostMapping(value="/datosusuario")
	public String metodo(@RequestParam("usuario") String usuario, @RequestParam("email") String email, @RequestParam("nombre") String nombre, @RequestParam("apellidos") String apellidos, Model mod) {
		System.out.println(usuario + ", " + email + ", " + nombre + ", " + apellidos);
		return "formulario";
	}
	
}
