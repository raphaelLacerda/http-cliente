
package rest;

import cliente.ClienteHTTPBuilder;
import interfaces.URL;
import javafx.geometry.Pos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Ignore
public class ClienteHTTPBuilderTest {

    private URL clienteHTTP;
    private String url;

    @Before
    public void setUp() {

        clienteHTTP = new ClienteHTTPBuilder().criarRequisicaoHTTP();
        url = "https://jsonplaceholder.typicode.com/users";
    }

    @Test
    public void deveFazerRequisicaoHTTPSemTransformarParaObjeto() {

        LinkedHashMap<String, String> resposta = clienteHTTP
                .comURL(url)
                .semParametros().aceitandoFormatoDefaultJSON()
                .invocandoMetodo().get(LinkedHashMap.class);

        Assert.assertEquals("Leanne Graham", resposta.get("name"));
    }

    @Test
    public void deveFazerRequisicaoTransformandoJSONEmUmObjeto() {

        Usuario usuario = clienteHTTP
                .comURL(url+ "/1").semParametros().aceitandoFormatoDefaultJSON()
                .invocandoMetodo().get(Usuario.class);

        Assert.assertEquals("Leanne Graham", usuario.getName());
        Assert.assertEquals("Sincere@april.biz", usuario.getEmail());
        Assert.assertEquals("Bret", usuario.getUsername());
    }

    @Test
    public void deveFazerRequisicaoTransformandoJSONEmUmaLista() {

        List<Usuario> usuarios = clienteHTTP
                .comURL(url).semParametros().aceitandoFormatoDefaultJSON()
                .invocandoMetodo().get(List.class);

        Assert.assertEquals("Leanne Graham", usuarios.get(0).getName());
    }

    @Test
    public void deveFazerRequisicaoTransformandoJSONEmUmaListaComQueryParam() {

        List<Post> posts = clienteHTTP
                .comURL("https://jsonplaceholder.typicode.com/posts").comQueryParam("userId", "1").aceitandoFormatoDefaultJSON()
                .invocandoMetodo().get(List.class);

        Assert.assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                    posts.get(0).getTitle());
    }

}
