
package interfaces;

public interface Cabecalho {
	
	public Cabecalho comHeaderNoRequest(String key, String value);
	
	public Cabecalho comCookiesNoRequest(String key, String value);
	
	public MetodosHttp invocandoMetodo();
}
