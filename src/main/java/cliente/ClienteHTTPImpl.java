
package cliente;


import interfaces.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;


class ClienteHTTPImpl implements ClienteHTTP, ParametrosComFormato, Cabecalho, MetodosHttp {

    private Client client;
    private Builder request;
    private WebTarget target;
    private String formatoDoEnvio;

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
     * formato default JSON {@link MediaType.APPLICATION_JSON}
     */
    @Override
    public Cabecalho aceitandoFormatoDefaultJSON() {

        request = target.request(MediaType.APPLICATION_JSON);

        return this;
    }

    @Override
    public Cabecalho aceitandoFormato(String formatoDaResposta) {

        request = target.request(formatoDaResposta);
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

        this.formatoDoEnvio = MediaType.APPLICATION_JSON;
        return this;
    }

    @Override
    public MetodosHttp invocandoMetodo(String media) {

        this.formatoDoEnvio = media;
        return this;
    }

    @Override
    public <T> T get(Class<T> clazzRetorno) {

        return request.get(clazzRetorno);
    }

    @Override
    public <T> List<T> getResultAsList(Class clazz) {


        ParameterizedType parameterizedGenericType = new ParameterizedType() {
            public Type[] getActualTypeArguments() {
                return new Type[] { clazz };
            }

            public Type getRawType() {
                return List.class;
            }

            public Type getOwnerType() {
                return List.class;
            }
        };

        GenericType<List<T>> genericType = new GenericType<List<T>>(
                parameterizedGenericType) {
        };

        return request.get(genericType);

    }

    @Override
    public <T> T post(Object dadosParaEnvio, Class<T> clazzRetorno) {

        if (dadosParaEnvio == null) {
            return request.post(null, clazzRetorno);
        }
        return request.post(Entity.entity(dadosParaEnvio, this.formatoDoEnvio), clazzRetorno);

    }

    @Override
    public <T> T put(Object dadosParaEnvio, Class<T> clazzRetorno) {

        if (dadosParaEnvio == null) {
            return request.put(null, clazzRetorno);
        }
        return request.put(Entity.entity(dadosParaEnvio, this.formatoDoEnvio), clazzRetorno);
    }

}
