package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping(value="/datosusuario")	// Formulario de registro de usuario
	public String metodo(HttpServletRequest request, Model model, HttpServletResponse response) {
		String user = request.getParameter("user");
		String email = request.getParameter("email");
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(user, email, nombre, password);
		model.addAttribute("usuario", usuario);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("usuarioses", usuario);
		model.addAttribute("usuarioses", usuario);
		
		Cookie c = new Cookie("emailcookie", email);
		c.setMaxAge(60*60*24*365*2);
		c.setPath("/vistausuario");
		response.addCookie(c);
		
		Cookie[] cookies = request.getCookies();
		String cookieName ="emailCookie";
		String cookieValue = "";
		if (cookies!=null){
			for (Cookie cookie: cookies){
				if (cookieName.equals(cookie.getName())) cookieValue = cookie.getValue();
			}
			model.addAttribute("valorCookie", c);
		}
		
		
		
		return "vistausuario";
		
	}
	
	@GetMapping(value="/usuariosesion")	// Muestra los datos del usuario en la sesión actual
	public String usuariosesion(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession(true);
		Usuario usuario = (Usuario)session.getAttribute("usuarioses");
		session.setAttribute("usuarioses", usuario);
		model.addAttribute("usuarioses", usuario);
		
		return "usuariosesion";
	}
	
	@Autowired
	DAOInterface dao;
	
	@GetMapping(value="/version")
	public String metodo(Model model) {
		
		//dao = new DAOTest();
		model.addAttribute("texto", dao .version());
		return "vista";
	}
	
}
