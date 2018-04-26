package rest;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Usuario {

	private String name;
	private String username;
	private String email;

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


