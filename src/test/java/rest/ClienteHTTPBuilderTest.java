
package rest;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cliente.ClienteHTTP;
import cliente.ClienteHTTPBuilder;

public class ClienteHTTPBuilderTest {
	
	private ClienteHTTP clienteHTTP;
	
	@Before
	public void setUp() {
		
		clienteHTTP = new ClienteHTTPBuilder().criarRequisicaoHTTP();
	}
	
	@Test
	public void deveFazerRequisicaoHTTP() {
		
		@SuppressWarnings("unchecked")
		Map<String, String> resposta = clienteHTTP
				.comURL("https://alm.intranet.bb.com.br/alm-integracao/APPS/verificaIntegracao")
				.comQueryParam("matricula", "F8437296").comQueryParam("saida", "json").aceitandoFormatoDefaultJSON()
				.invocandoMetodo().get(Map.class);
		
		Assert.assertEquals("alm-integracao-atc-ui-web", resposta.get("aplicacao"));
		Assert.assertEquals("F8437296", resposta.get("matricula"));
	}
	
	@Test
	public void deveFazerRequisicaoTransformandoJSON() {
		
		FuncionarioIntegracao funcionario = clienteHTTP
				.comURL("https://alm.intranet.bb.com.br/alm-integracao/APPS/verificaIntegracao")
				.comQueryParam("matricula", "F8437296").comQueryParam("saida", "json").aceitandoFormatoDefaultJSON()
				.invocandoMetodo().get(FuncionarioIntegracao.class);
		
		Assert.assertEquals("alm-integracao-atc-ui-web", funcionario.getAplicacao());
		Assert.assertEquals("F8437296", funcionario.getMatricula());
		Assert.assertNotNull(funcionario.getEquipesUor().get(0));
	}
	
}
