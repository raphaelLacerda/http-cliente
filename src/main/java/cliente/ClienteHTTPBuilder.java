
package cliente;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import conexao.HabilitadorSSL;

public class ClienteHTTPBuilder {
	
	public ClienteHTTP criarRequisicaoHTTP() {
		
		Client client = ClientBuilder.newBuilder().hostnameVerifier(new HostnameVerifier() {
			
			@Override
			public boolean verify(String hostname, SSLSession session) {
				
				return true;
			}
		}).sslContext(new HabilitadorSSL().getSSL()).build();
		return new ClienteHTTPImpl(client);
	}
}
