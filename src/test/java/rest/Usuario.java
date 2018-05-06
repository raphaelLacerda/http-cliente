package rest;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Usuario {

	private int id;
	private String name;
	private String username;
	private String email;

	private String matricula;
	private List<String> siglas;

	public Usuario(String matricula, List<String> siglas) {
		super();
		this.matricula = matricula;
		this.siglas = siglas;
	}

	public Usuario (){

	}

	public String getMatricula() {

		return matricula;
	}

	public List<String> getSiglas() {

		return siglas;
	}



	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}


}


