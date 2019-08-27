/**
 * 
 */
package br.gov.fazenda.mg.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author claudiney.viana
 *
 */
public class ServletUtil {
	
	public static final String TITULO_LOGOUT = "Logout realizado com sucesso.";
	public static final String MESSAGE_LOGOUT = "Para sair do sistema com seguran�a, feche todas as janelas do seu navegador.";
	public static final String TITULO_SESSAOEXP = "Sess�o expirada";
	public static final String MESSAGE_SESSAOEXP = "A sua sess�o expirou por tempo de inatividade ou voc� j� clicou no bot�o Sair com Seguran�a. " +
												   "Para voltar a utilizar o sistema, feche o seu navegador e acesse-o novamente.";	
	public static final String MESSAGE_CERT_INVALIDO = "Certificado n�o v�lido, favor entrar em contato com o Fornecedor do seu Certificado.";
	
	public static void forward(String aResponsePage, HttpServletRequest aRequest, HttpServletResponse aResponse) throws ServletException, IOException {
		if(!aResponse.isCommitted()){
			RequestDispatcher dispatcher = aRequest.getRequestDispatcher(aResponsePage);		
			dispatcher.forward(aRequest, aResponse);		
		}
	}	
}
