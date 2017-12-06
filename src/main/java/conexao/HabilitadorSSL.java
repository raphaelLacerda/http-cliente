
package conexao;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HabilitadorSSL {
	
	
	public SSLContext getSSL() {
		
		SSLContext ctx = null;
		TrustManager[] trustAllCerts = new X509TrustManager[] { new X509TrustManager() {
			
			@Override
			public X509Certificate[] getAcceptedIssuers() {
				
				return null;
			}
			
			@Override
			public void checkClientTrusted(X509Certificate[] certs, String authType) {
				//implementação da interface X509
			}
			
			@Override
			public void checkServerTrusted(X509Certificate[] certs, String authType) {
				//implementação da interface X509				
			}
		} };
		try {
			ctx = SSLContext.getInstance("SSL");
			ctx.init(null, trustAllCerts, null);

			SSLContext.setDefault(ctx);
			
			return ctx;
		} catch (NoSuchAlgorithmException | KeyManagementException e) {
			throw new IllegalStateException("impossível habilitar SSL", e);
		}
		
	}
}
