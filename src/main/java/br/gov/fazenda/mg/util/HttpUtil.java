/**
 * 
 */
package br.gov.fazenda.mg.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * @author claudiney.viana
 *
 */
public class HttpUtil {
	
	public static void decodeImagemB64(String srcImage){		
		byte[] decodedString = Base64.decode(srcImage.substring(srcImage.indexOf("data:image/png;base64,") + "data:image/png;base64,".length()));
				
		ByteArrayInputStream is = new ByteArrayInputStream(decodedString);
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(new File("captcha.png"));
			byte[] buffer = new byte[1024];
			int length;
			
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {			
			try {
				is.close();
				os.close();			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public static String getHtmlPage(String url){
		URLConnection conexao = null;
		Socket so = null;
		StringBuilder htmlS = new StringBuilder();
		 try {
			 connectHttps();
			 URL con = null;
			con = new URL(url);
			so = new Socket("proxy.fazenda.mg.gov.br", 8003);			
			so.setSoTimeout(60000);
			conexao = con.openConnection(new Proxy(Proxy.Type.HTTP, so.getRemoteSocketAddress()));
						
			InputStream is;
			is = conexao.getInputStream();
			BufferedReader dis;
			dis = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			String s = "";
			
			while((s = dis.readLine()) != null){
				//System.out.println(s+"\n");
				htmlS.append(s+"\n");
			}
		} catch (Exception e){
			e.printStackTrace();
		} 
	 return htmlS.toString();
	}
	
	public static void connectHttps(){
		// Create a trust manager that does not validate certificate chains
		 TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
	            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	                return null;
	            }	 
	            public void checkClientTrusted(
	                    java.security.cert.X509Certificate[] certs, String authType) {
	            }
	 
	            public void checkServerTrusted(
	                    java.security.cert.X509Certificate[] certs, String authType) {
	            }
	        } };
		// Install the all-trusting trust manager
		SSLContext sc;
		try {
			sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}

		// Create all-trusting host name verifier
		HostnameVerifier allHostsValid = new HostnameVerifier() {
				@Override
			public boolean verify(String hostname, SSLSession session) {
				// TODO Auto-generated method stub
				return true;
			}
		};
		// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	}
}