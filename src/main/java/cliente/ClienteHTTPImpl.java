
package cliente;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import interfaces.Cabecalho;
import interfaces.Formato;
import interfaces.MetodosHttp;
import interfaces.Parametros;
import interfaces.ParametrosComFormato;

class ClienteHTTPImpl implements ClienteHTTP, ParametrosComFormato, Cabecalho, MetodosHttp {
	
	private Client		client;
	private Builder		request;
	private WebTarget	target;
	
	ClienteHTTPImpl(Client client) {
		this.client = client;
	}
	
	@Override
	public Parametros comURL(String url) {
		
		this.target = client.target(url);
		
		return this;
	}
	
	@Override
	public ParametrosComFormato comQueryParam(String key, String value) {
		
		this.target = this.target.queryParam(key, value);
		return this;
	}
	
	@Override
	public Formato semParametros() {
		
		return this;
	}
	
	/**
	 * 
	 * 
	 * formato default JSON {@link MediaType.APPLICATION_JSON}
	 */
	@Override
	public Cabecalho aceitandoFormatoDefaultJSON() {
		
		request = target.request(MediaType.APPLICATION_JSON);
		
		return this;
	}
	
	@Override
	public Cabecalho aceitandoFormato(String media) {
		
		request = target.request(media);
		return this;
	}
	
	@Override
	public Cabecalho comHeaderNoRequest(String key, String value) {
		
		request.header(key, value);
		return this;
	}
	
	@Override
	public Cabecalho comCookiesNoRequest(String key, String value) {
		
		request.cookie(key, value);
		return this;
	}
	
	@Override
	public MetodosHttp invocandoMetodo() {
		
		return this;
	}
	
	@Override
	public <T> T get(Class<T> clazzRetorno) {
		
		return request.get(clazzRetorno);
	}
	
	@Override
	public <T> T post(Object dadosParaEnvio, Class<T> clazzRetorno) {
		
		return request.post(Entity.entity(dadosParaEnvio, MediaType.APPLICATION_JSON), clazzRetorno);
	}
	
	@Override
	public <T> T put(Object dadosParaEnvio, Class<T> clazzRetorno) {
		
		return request.put(Entity.entity(dadosParaEnvio, MediaType.APPLICATION_JSON), clazzRetorno);
	}
	
}
