
package interfaces;

import java.util.List;

public interface MetodosHttp {

	public <T> T get(Class<T> clazzRetorno);

	public <T> List<T> getResultAsList(Class clazzRetorno);

	public <T> T post(Object dadosParaEnvio, Class<T> clazzRetorno);

	public <T> T put(Object dadosParaEnvio, Class<T> clazzRetorno);
}
