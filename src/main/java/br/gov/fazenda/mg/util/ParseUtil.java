/**
 * 
 */
package br.gov.fazenda.mg.util;

/**
 * @author claudiney.viana
 *
 */
public class ParseUtil {
	
	public static String[] parseCodNome(String codNome){	
		String[] retorno = new String[]{codNome};		
		if(codNome.contains("-")){
			retorno = codNome.split("-");
		} else {
			retorno = new String[]{codNome};
		}
		return retorno;		
	}
	
	public static String[] replaceByCharacter(String txt, String character){	
		String[] retorno;		
		if(txt.contains(character)){
			retorno = txt.split(character);
		} else {
			retorno = new String[]{txt};
		}
		return retorno;		
	}
	
	public static String getCod(String vCampo){
		if(vCampo == null || vCampo.isEmpty()){
			return "";
		} else if(vCampo.contains("-")){
			return vCampo.substring(0,vCampo.indexOf("-")).trim();
		} else if(vCampo.contains("=")){
			return vCampo.substring(0,vCampo.indexOf("=")).trim();	
		} else {
			return vCampo;
		}		
	}
	
	public static String formattDataHora(String dtHora) throws Exception{		 
		String dtHoraFormatt = "";
		String dtOriginal = dtHora.substring(0, 10);	
		String hrOriginal = dtHora.substring(dtHora.length()-8, dtHora.length());
		String dtFormatt = DateUtil.dateStringFormatt(dtOriginal);		
		dtHoraFormatt = dtFormatt + "T" + hrOriginal;
		return dtHoraFormatt;
	}

}
