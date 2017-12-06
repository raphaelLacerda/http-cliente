
package interfaces;

public interface MetodosHttp {
	
	public <T> T get(Class<T> clazzRetorno);
	
	public <T> T post(Object dadosParaEnvio, Class<T> clazzRetorno);
	
	public <T> T put(Object dadosParaEnvio, Class<T> clazzRetorno);
}
