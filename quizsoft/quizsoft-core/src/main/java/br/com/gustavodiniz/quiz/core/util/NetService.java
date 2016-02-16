package br.com.gustavodiniz.quiz.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetService {

	public String executaGet(String dominio, String urlServico, String param) {
		String output = "";
		try {
			URL url = null;
			
			if(param != null){
				url = new URL(dominio+urlServico+"?"+param);
			}else{
				url = new URL(dominio+urlServico);
			}
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()), "UTF-8"));

			output = br.readLine();

			conn.disconnect();

			
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
//		System.out.println(output);
		return output;

	}

	public String executaPost(String dominio, String urlServico, String param) {
		String output = null;
		try {
			URL url = new URL(dominio+urlServico);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");  

			OutputStream os = conn.getOutputStream();
			os.write(param.getBytes());
			os.flush();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "+conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()),"UTF8"));

			output = br.readLine();

			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println(output);
		return output; 

	}

	public static void main(String[] args) {
		
		String param = "formJson={\"mensagem\":\"Qual o prazo para o teste 2 ?\",\"nome\":\"Gustavo Diniz2\",\"email\":\"gustavo.diniz1ontracker.com.br\",\"idade\":29}";
		new NetService().executaPost("http://localhost:8080/quizsoft-web", "/template/adicionarFormulario", param);
		
		param = "formJson={\"mensagem\":\"Qual o prazo para o teste 3 ?\",\"nome\":\"Gustavo Diniz3\",\"email\":\"gustavo.diniz2@ontracker.com.br\",\"idade\":29}";
		new NetService().executaPost("http://localhost:8080/quizsoft-web", "/template/adicionarFormulario", param);
		
		param = "formJson={\"mensagem\":\"Qual o prazo para o teste 4 ?\",\"nome\":\"Gustavo Diniz4\",\"email\":\"gustavo.diniz3@ontracker.com.br\",\"idade\":29}";
		new NetService().executaPost("http://localhost:8080/quizsoft-web", "/template/adicionarFormulario", param);
	}
}
