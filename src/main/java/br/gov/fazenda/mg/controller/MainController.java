/**
 * 
 */
package br.gov.fazenda.mg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author claudiney.viana
 *
 */
@Controller
public class MainController {
	
	@RequestMapping(value = { "/*", "/*/*" }, method = RequestMethod.GET)
	public String handler (Model model) {
		return "/index";
	}	
}
