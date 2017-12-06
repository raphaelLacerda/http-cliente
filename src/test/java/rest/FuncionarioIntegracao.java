package rest;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class FuncionarioIntegracao {
	
	private String aplicacao;
	private String matricula;
	private String versao;
	private List<String> equipesUor = new ArrayList<>();
	@Override
	public String toString() {
		
		return "FuncionarioIntegracao [aplicacao=" + aplicacao + ", matricula=" + matricula + ", versao=" + versao
				+ ", equipesUor=" + equipesUor + "]";
	}
	
	public String getAplicacao() {
		
		return aplicacao;
	}
	
	public void setAplicacao(String aplicacao) {
		
		this.aplicacao = aplicacao;
	}
	
	public String getMatricula() {
		
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		
		this.matricula = matricula;
	}
	
	public String getVersao() {
		
		return versao;
	}
	
	public void setVersao(String versao) {
		
		this.versao = versao;
	}
	
	public List<String> getEquipesUor() {
		
		return equipesUor;
	}
	
	public void setEquipesUor(List<String> equipesUor) {
		
		this.equipesUor = equipesUor;
	}
	
	
	
	
	
}
