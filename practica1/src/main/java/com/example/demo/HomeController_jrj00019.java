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
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController_jrj00019 {
	
	@Autowired
	DAOInterface dao;
	
	@GetMapping(value="/datosusuario")
	public String formulario() {
		return "formulario_jrj00019";
	}
	
	@PostMapping(value="/datosusuario")	// Formulario de registro de usuario
	public String metodo(HttpServletRequest request, Model model, HttpServletResponse response) {
		String user = request.getParameter("user");
		String email = request.getParameter("email");
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(user, email, nombre, password);
		model.addAttribute("usuario", usuario);
		
		// Inserción en la base de datos
		//dao.insertaUsuario(user, email, nombre, password);
		dao.insertaUsuario(usuario);
		
		// Cookie de sesión
		HttpSession session = request.getSession(true);
		session.setAttribute("usuarioses", usuario);
		model.addAttribute("usuarioses", usuario);
		
		// Cookie permanente
		Cookie c = new Cookie("emailcookie", email);
		c.setMaxAge(60*60*24*365*2);
		c.setPath("/usuariosesion");
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
		
		
		
		return "vistausuario_jrj00019";
		
	}
	
	@GetMapping(value="/usuariosesion")	// Muestra los datos del usuario en la sesión actual
	public String usuariosesion(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession(true);
		Usuario usuario = (Usuario)session.getAttribute("usuarioses");
		session.setAttribute("usuarioses", usuario);
		model.addAttribute("usuarioses", usuario);
		
		return "usuariosesion_jrj00019";
	}
	
	// Sesión 2
	
	@GetMapping(value="/version")
	public String versionDAO(Model model) {
		model.addAttribute("texto", dao.version());
		return "vista_jrj00019";
	}
	
	@GetMapping(value="/login")
	public String login() {
		return "login_jrj00019";
	}
	
	@PostMapping(value="/login")
	public String buscaUsuario(HttpServletRequest request, Model model, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		
		//if(session != null) {
		//	return "tienda";
		//}else {
			String user = request.getParameter("user");
			String password = request.getParameter("password");
			model.addAttribute("usulogin", user);
			model.addAttribute("passlogin", password);
			
			if(dao.compruebaAdmin(user, password)) {
				model.addAttribute("lista", dao.leeUsuarios());
				return "listausuarios_jrj00019";
			}else {
				if(dao.compruebaUsuario(user, password)) {
					session = request.getSession(true);
					return "tienda_jrj00019";
				}else {
					return "error_jrj00019";
				}
			}
			
		//}
		
	}
		
	
}
