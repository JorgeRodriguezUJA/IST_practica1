package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service	// No se si es Service o Repository
public class DAOTest implements DAOInterface {

	 @Autowired
	 private DAOInterface dao;	// No se si esto es necesario
	 
	@Override
	public String version() {
		return "Estamos usando la clase DAOTest";
	}
	
	@Override
	public ArrayList<Usuario> leeUsuarios(){
		/*ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario1 = new Usuario("Solracre", "carlos@gmail.com", "Carlos Perez Delgado", "porrito");	// User, email, nombre, password
		usuarios.add(usuario1);
		Usuario usuario2 = new Usuario("Saselandia", "fuckpiperos@gmail.com", "Francisco de Borja Cobo Hervás", "vivavox");
		usuarios.add(usuario2);
		Usuario usuario3 = new Usuario("ValdeandeMagico", "valdeande@gmail.com", "Jose Alfonso Hernando Abejon", "vortices");
		usuarios.add(usuario3);
		
		return usuarios;*/
		
		return dao.leeUsuarios();
	}
	
	

}
