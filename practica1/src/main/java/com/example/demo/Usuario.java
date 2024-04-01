package com.example.demo;

import java.io.Serializable;

public class Usuario implements Serializable {

	private int id;
	private String user;
	private String email;
	private String nombre;
	private String password;
	
	public Usuario(int id, String user, String email, String nombre, String password) {
		this.id = id;
		this.user = user;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
	}
	
	int cont=0;
	
	public Usuario(String user, String email, String nombre, String password) {
		this.id = cont;
		this.user = user;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		cont++;
	}

	public Usuario() {
		user="";
		email="";
		nombre="";
		password="";
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
