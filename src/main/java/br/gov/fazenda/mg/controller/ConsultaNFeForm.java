/**
 * 
 */
package br.gov.fazenda.mg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author claudiney.viana
 *
 */
@Controller
public class ConsultaNFeForm {

	@RequestMapping("/ConsultaNFeForm")
	public String consulta(@RequestParam(value = "chave") String chave, 
			@RequestParam(value = "password") String password,
			@RequestParam(value = "username") String username) {
		System.out.println("CONSULTAOU!!!!!!!!!!!!!!!!!" +
			" Chave= "+chave+
			" username = "+username);
		return "/index";
	}
	
	
	/*

	@RequestMapping("/ConsultaNFeFormServlet")
	@Override
	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String chave = req.getParameter("chave");
		String j_username = req.getParameter("username");
		String j_password = req.getParameter("password");
		
		if(chave == null)
			chave = "";		
				
		req.setAttribute("chave", chave);		
		//forward("pages/consultaNFe.an", req, resp);
		//j_username=ADM_AE&j_password=3dlp9pcy
		
		forward("j_spring_security_check?j_username="+j_username+"&j_password="+j_password, req, resp);		
	}	*/
}
