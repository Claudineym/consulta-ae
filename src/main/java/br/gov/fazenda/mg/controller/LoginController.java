package br.gov.fazenda.mg.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.fazenda.mg.domain.LoginResponseBody;
import br.gov.fazenda.mg.jsonview.Views;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginController {
	
	@Value("${jwt.secret}")
	private String key;
	
	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView  login (@RequestParam(value = "error", required = false) String error,
								@RequestParam(value = "logout", required = false) String logout) {
		
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("/login");
		return model;
	}*/	
	
	@JsonView(Views.Public.class)
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<?> authenticate(
			@RequestParam(value = "j_username") String j_username,
			@RequestParam(value = "j_password") String j_password) {
		
		String user = "123";
		String pass = "123";
		
		if(j_username.equals("")) {			
			return new ResponseEntity<Object>(new LoginResponseBody(false, null, "MASP é obrigatório!", "USER"),
                    HttpStatus.OK);
		} else if(j_password.equals("")) {
			return new ResponseEntity<Object>(new LoginResponseBody(false, null, "Senha é obrigatória!", "PASSWORD"),
                    HttpStatus.OK);
		} else if(!j_username.equals(user) || !j_password.equals(pass)) {
			return new ResponseEntity<Object>(new LoginResponseBody(false, null, "Favor conferir MASP ou senha!", "DADOS_ERRADOS"),
                    HttpStatus.OK);
		}
		
		String token = Jwts.builder()
                .setSubject(j_username)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
				
		return new ResponseEntity<Object>(new LoginResponseBody(true, token), HttpStatus.OK);		
	}
}
