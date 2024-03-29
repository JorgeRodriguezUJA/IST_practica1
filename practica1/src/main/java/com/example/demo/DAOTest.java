package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;



@Repository
public class DAOTest implements DAOInterface {
	
	//static final String usu = "carlos";
	//static final String pass = "carlos";
	 
	@Override
	public String version() {
		return "Estamos usando la clase DAOTest";
	}
	
	@Override
	public List<Usuario> leeUsuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		// User, email, nombre, password
		usuarios.add(new Usuario("admin", "admin@gmail.com", "admin", "admin"));
		usuarios.add(new Usuario("Solracre", "carlos@gmail.com", "Carlos Perez Delgado", "porrito"));
		usuarios.add(new Usuario("Saselandia", "fuckpiperos@gmail.com", "Francisco de Borja Cobo Hervás", "vivavox"));
		usuarios.add(new Usuario("ValdeandeMagico", "valdeande@gmail.com", "Jose Alfonso Hernando Abejon", "vortices"));
		usuarios.add(new Usuario("a", "a@gmail.com", "a b c", "a"));
		
		return usuarios;
		
	}
	
	@Override
	public boolean compruebaUsuario(String user, String password){
		
		boolean autenticado = false;
		
		for (Usuario usuario : leeUsuarios()) {
		    
		    String usu = usuario.getUser();
		    String pass = usuario.getPassword();
		    
		    if(user.equals(usu) && password.equals(pass)) {
				autenticado = true;
			}
		}
		
		if(autenticado) {
			return true;
		} else {
			return false;
		}
		
	}
	
	@Override
	public boolean compruebaAdmin(String user, String password){
		// El usuario administrador siempre ocupará la posición 0 del arraylist
		if(user.equals(leeUsuarios().get(0).getUser()) && password.equals(leeUsuarios().get(0).getPassword())) {
			return true;
		}else {
			return false;
		}
		
	}

}
