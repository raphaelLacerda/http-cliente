
package rest;

import cliente.ClienteHTTPBuilder;
import interfaces.ClienteHTTP;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

public class ClienteHTTPBuilderTest {

    private ClienteHTTP clienteHTTP;
    private String url = "https://jsonplaceholder.typicode.com/users";

    @Before
    public void setUp() {
        clienteHTTP = new ClienteHTTPBuilder().criarRequisicaoHTTP();

    }

    @Test
    public void deveFazerRequisicaoGETTransformandoJSONEmUmObjeto() {

        Usuario usuario = clienteHTTP
                .comURL(url + "/1").semParametros().aceitandoFormatoDefaultJSON()
                .invocandoMetodo().get(Usuario.class);

        Assert.assertEquals("Leanne Graham", usuario.getName());
        Assert.assertEquals("Sincere@april.biz", usuario.getEmail());
        Assert.assertEquals("Bret", usuario.getUsername());
    }

    @Test
    public void deveFazerRequisicaoGETTransformandoJSONEmUmaLista() throws IOException {

        List<Usuario> usuarios = clienteHTTP
                .comURL(url).semParametros().aceitandoFormatoDefaultJSON()
                .invocandoMetodo().getResultAsList(Usuario.class);
        Assert.assertEquals("Leanne Graham", usuarios.get(0).getName());
    }

    @Test
    public void deveFazerRequisicaoGETTransformandoJSONEmUmaListaComQueryParam() {

        List<Post> retorno = clienteHTTP
                .comURL("https://jsonplaceholder.typicode.com/posts").comQueryParam("userId", "1").aceitandoFormatoDefaultJSON()
                .invocandoMetodo().<Post>getResultAsList(Post.class);

        Assert.assertNotNull(retorno.get(0).getTitle());

    }


    @Test
    public void deveFazerRequisicaoGETTransformandoEmTexto() {

        String resposta = clienteHTTP
                .comURL(url).semParametros().aceitandoFormato(MediaType.TEXT_PLAIN)
                .invocandoMetodo().get(String.class);

        Assert.assertNotNull(resposta);
    }


    @Test
    public void deveFazerRequisicaoPOST(){
        Post post = new Post();
        post.setTitle("meu novo post");

        Post novoPost = clienteHTTP.comURL("https://jsonplaceholder.typicode.com/posts")
                .semParametros()
                .aceitandoFormatoDefaultJSON()
                .invocandoMetodo().post(post, Post.class);

        Assert.assertTrue(novoPost.getId() > 0);
    }
//
//    @Test
//    public void teste(){
//        List<Usuario> list = ClientBuilder.newBuilder().build().target(url)
//                .request(MediaType.APPLICATION_JSON)
//
//
//        System.out.println(list.size());
//        System.out.println(list.get(0).getClass());
//    }
}
