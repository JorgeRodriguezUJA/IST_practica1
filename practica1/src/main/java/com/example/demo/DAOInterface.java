package com.example.demo;

import java.util.List;

public interface DAOInterface {

	public String version();
	public List<Usuario> leeUsuarios();
	public boolean compruebaUsuario(String user, String password);
	public boolean compruebaAdmin(String user, String password);
	
}
