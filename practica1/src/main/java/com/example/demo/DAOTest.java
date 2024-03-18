package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;



//@Service	// No se si es Service o Repository
public class DAOTest implements DAOInterface {
	
	static final String usu = "carlos";
	static final String pass = "carlos";

	@Autowired
	private DAOInterface dao;	// No se si esto es necesario
	 
	@Override
	public String version() {
		return "Estamos usando la clase DAOTest";
	}
	
	@Override
	public ArrayList<Usuario> leeUsuarios(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		// User, email, nombre, password
		usuarios.add(new Usuario("Solracre", "carlos@gmail.com", "Carlos Perez Delgado", "porrito"));
		usuarios.add(new Usuario("Saselandia", "fuckpiperos@gmail.com", "Francisco de Borja Cobo Hervás", "vivavox"));
		usuarios.add(new Usuario("ValdeandeMagico", "valdeande@gmail.com", "Jose Alfonso Hernando Abejon", "vortices"));
		
		//return usuarios;
		
		return dao.leeUsuarios();
	}
	
	public String autenticar(String user, String password) {
		
		if(user == usu && password == pass) {
			return "tienda";
		} else {
			return "tienda";
		}
		
	}
	
	
	
	

}
