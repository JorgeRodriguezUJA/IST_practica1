package com.example.demo;

import org.springframework.stereotype.Repository;

@Repository
public class DAOTest implements DAOInterface {

	@Override
	public String version() {
		return "Estamos usando la clase DAOTest";
	}

}
