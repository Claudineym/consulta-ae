/**
 * 
 */
package br.gov.fazenda.mg.util;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author claudiney.viana
 *
 */
public class ValidaCampo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public static boolean validaCampoBusca(String campo){
		return campo == null || campo.equals("") ? true : false;
	}
	
	public static String replaceDoc(String doc){			
		return doc.replaceAll("[.^-^/^-]", "");
	}
	
	public static String replaceTelefone(String tel){			
		return tel.replaceAll("[.^(^)^-]", "");
	}
	
	public static String replaceNumVirgulaToPonto(String num){
		return num.replace(",", ".");
	}
	
	public static boolean validaDataIniDataFim(Date dtIni, Date dtFim){
		return dtIni.after(dtFim);
	}
	
	/**
	 * M�todo que valida o tamanho da senha entre min e max caracteres
	 * @return boolean com a valida��o 
	 */
	public static boolean validarSenhaSalvar(String password, int min, int max){			
		if((password.length() < min || password.length() > max)){			
			return true;
		} else{
			return false;
		}
	}
	
	public static boolean validarUsuarioSalvador(String masp){
		String MASP_SALVADOR = "386847";
		return masp.equals(MASP_SALVADOR) ? false : true;
	}
	
	public static boolean validarEmailFazendaMG(String email){		 
	        if (!email.contains("@fazenda.mg.gov.br")) {
	            /*FacesContext.getCurrentInstance().addMessage(null,
	                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
	                    email + " e-mail n�o � v�lido (@fazenda.mg.gov.br) "));*/
	            return false;
	        }
			return true;
	}
	
	public static boolean isValidEmail(String email) {		 
        // Reqular expression pattern to validate the format submitted
        String validator = "^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+"
                + "(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{2,})$";
 
        if (!email.matches(validator)) {
            return false;
        } 
        return true;                   
    }
	
	 public static boolean isCelular(String numeroCel) {	    
		 String formato = "\\([0-9]{2}?\\) \\([0-9]{2}?\\) [0-9]{4}?\\-[0-9]{4}?";		 
		 if((numeroCel == null) || (numeroCel.length()!=19) || (!numeroCel.matches(formato))){
			 /*FacesContext.getCurrentInstance().addMessage(null,
	                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
	                    		numeroCel + " n�o � v�lido (00)(00)0000-0000 "));*/
			 return false;
		 }		 
		 return true;
	 }
	 
	 public static boolean isTelefone(String numeroTelefone) {	    
		 String formato = "\\([0-9]{2}?\\) [0-9]{4}?\\-[0-9]{4}?";		 
		 if((numeroTelefone == null) || (numeroTelefone.length()!=14) || (!numeroTelefone.matches(formato))){
			 /* FacesContext.getCurrentInstance().addMessage(null,
	                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
	                    		numeroTelefone + " n�o � v�lido (00) 0000-0000 "));*/
			  return false;
		 }		 
		 return true;
	 }
	 
	public static boolean validarSenha(String password, String confirmePassword) {
		if (password.contentEquals(confirmePassword)) {
			if (validarSenhaSalvar(password, 8, 20)) { // valida a senha
				/*FacesContext
						.getCurrentInstance()
						.addMessage(
								"messageTemplate",
								new FacesMessage(FacesMessage.SEVERITY_ERROR,
										"Info.",
										"Tamanho da Senha deve conter no m�nimo 8 caracteres e no m�ximo 20."));*/
			} else {
				return true;
			}
		} else {
			/*FacesContext.getCurrentInstance().addMessage(
					"messageTemplate",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro.",
							"Senhas n�o conferem."));*/
		}
		return false;
	}

	public static boolean validaSomenteNumeros(String num) {
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(num);
		return m.matches() == true ? false : true;
	}	
}