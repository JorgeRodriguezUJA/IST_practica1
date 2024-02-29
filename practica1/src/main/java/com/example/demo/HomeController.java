package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	/*@GetMapping(value="/vistausuario")	// De esta forma se da por hecho que es un GET
	public String metodo(Model model) {
		String cadenadetexto="Esto es un mensaje del controlador. Prueba segundo commit";
		model.addAttribute("mensaje", cadenadetexto);	// Grabamos mensaje con el contenido de cadenadetexto
		return "vista";
	}*/
	
	@GetMapping(value="/datosusuario")
	public String formulario() {
		return "formulario";
	}
	
	@PostMapping(value="/datosusuario")
	public String metodo(HttpServletRequest request, Model model) {
		String user = request.getParameter("user");
		String email = request.getParameter("email");
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(user, email, nombre, password);
		model.addAttribute("usuario", usuario);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("usuarioses", usuario);
		model.addAttribute("usuarioses", usuario);
		
		return "vistausuario";
		
	}
	
	@GetMapping(value="/usuariosesion")
	public String usuariosesion() {
		return "usuariosesion";
	}
	
	/*@PostMapping(value="/datosusuario")
	public String metodo(HttpServletRequest request, HttpServletResponse response, Model model) {
		String user = request.getParameter("user");
		String email = request.getParameter("email");
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(user, email, nombre, password);
		
		//UsuarioDB basededatos = new UsuarioDB();
		//String email = basededatos.add(usuario);
		
		model.addAttribute("usuario", usuario);
		
		HttpSession session = request.getSession();
		session.setAttribute("usuario", usuario);
		
		Cookie c = new Cookie("emailCookie", email);
		c.setMaxAge(60*60*24*365*3);	// Cookie permanente de 3 años
		c.setPath("/");
		response.addCookie(c);
		
		System.out.println(usuario + ", " + email + ", " + nombre + ", " + password);
		return "formulario";
	}*/
	
	
	
}
