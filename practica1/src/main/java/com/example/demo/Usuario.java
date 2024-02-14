package com.example.demo;

import java.io.Serializable;

public class Usuario implements Serializable {

	private String user;
	private String email;
	private String nombre;
	private String password;
	
	public Usuario(String user, String email, String nombre, String password) {
		this.user = user;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
	}

	public Usuario() {
		user="";
		email="";
		nombre="";
		password="";
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
}
