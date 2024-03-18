package com.example.demo;

import java.util.ArrayList;

public interface DAOInterface {

	public String version();
	public ArrayList<Usuario> leeUsuarios();
	public String autenticar(String user, String password);
	
}
