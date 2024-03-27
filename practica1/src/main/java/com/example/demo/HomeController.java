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
public class HomeController {
	
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
	
	// Sesión 2
	
	@Autowired
	DAOInterface dao;
	
	@GetMapping(value="/version")					// Con la ruta /version llamo al metodo version de DAOTest
	public String versionDAO(Model model) {			// Tengo que hacer lo mismo con leeUsuarios
		//dao = new DAOTest();
		model.addAttribute("texto", dao.version());
		return "vista";
	}
	
	@GetMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@PostMapping(value="/login")
	public String buscaUsuario(HttpServletRequest request, Model model, HttpServletResponse response) {
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		model.addAttribute("usulogin", user);
		model.addAttribute("passlogin", password);
		
		if(dao.compruebaUsuario(user, password)) {
			return "tienda";
		}else {
			return "error";
		}
	}
	
	/*@GetMapping(value="/leeusuarios")
	public String leeUsuarios(Model model) {
		
		List<Usuario> lista = new ArrayList<Usuario>();
		lista = dao.leeUsuarios();	// Pongo dao porque es como le he llamado arriba en el Autowired
		//model.addAttribute("usuarios", lista);
		for (Usuario usuario : lista) {
		    String user = usuario.getUser();
		    String password = usuario.getPassword();
		    
		    System.out.println("Usuarios: " + user + ", Password: " + password);
		}
		return "usuarios";
	}*/
		
	
}
