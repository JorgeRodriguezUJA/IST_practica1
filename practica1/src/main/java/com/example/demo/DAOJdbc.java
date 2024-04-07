package com.example.demo;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository		// Se cambia el repository entre DAOTest y DAOJdbc según cual se quiera usar
public class DAOJdbc implements DAOInterface{

	private JdbcTemplate jdbcTemplate;
	@Autowired
	
	public void setDataSource(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public String version() {
		return "Estamos usando la clase DAOTest";
	}

	public List<Usuario> leeUsuarios(){
		String sql = "SELECT * from usuarios";	// usuarios es el nombre de la tabla
		List<Usuario> usuarios = this.jdbcTemplate.query(sql, mapper);
		return usuarios;
	}

	private final RowMapper<Usuario> mapper = (rs,numRow) -> {
		Usuario usuario = new Usuario();
		usuario.setId(rs.getInt("id"));
		usuario.setUser(rs.getString("user"));
		usuario.setEmail(rs.getString("email"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setPassword(rs.getString("password"));
		return usuario;
		};
		
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
		
		// El usuario administrador siempre ocupará la posición 0 de la tabla usuarios
		if(user.equals(leeUsuarios().get(0).getUser()) && password.equals(leeUsuarios().get(0).getPassword())) {
			return true;
		}else {
			return false;
		}
		
	}
	
	@Override
	public void insertaUsuario(Usuario usuario) {

		String sql = "INSERT into usuarios (user, email, nombre, password) values (?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, usuario.getUser(), usuario.getEmail(), usuario.getNombre(), usuario.getPassword());
		
	}
	
	public List<Usuario> buscaUsuario(int id) {
		
		String sql = "SELECT * from usuarios WHERE id = ?";
		List<Usuario> usuarios = this.jdbcTemplate.query(sql, mapper, id);
		return usuarios;
		
	}
	
	
	
	
}