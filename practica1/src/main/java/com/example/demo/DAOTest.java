package com.example.demo;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class DAOTest implements DAOInterface {

	@Override
	public String version() {
		return "Estamos usando la clase DAOTest";
	}
	
	@Override
	public ArrayList<Usuario> leeUsuarios(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario1 = new Usuario("Solracre", "carlos@gmail.com", "Carlos Perez Delgado", "porrito");	// User, email, nombre, password
		usuarios.add(usuario1);
		Usuario usuario2 = new Usuario("Saselandia", "fuckpiperos@gmail.com", "Francisco de Borja Cobo Hervás", "vivavox");
		usuarios.add(usuario2);
		Usuario usuario3 = new Usuario("ValdeandeMagico", "valdeande@gmail.com", "Jose Alfonso Hernando Abejon", "vortices");
		usuarios.add(usuario3);
		
		return usuarios;
	}
	
	

}
