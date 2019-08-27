/**
 * 
 */
package br.gov.fazenda.mg.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author claudiney.viana
 *
 */
public class DateUtil {
	
	public static String dateStringFormatt(String data) throws Exception{		
		SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		 String reformattedStr = "";
		try {
		    reformattedStr = myFormat.format(fromUser.parse(data));
		} catch (ParseException e) {
		    throw new Exception(e);
		}
		return reformattedStr;
	}

}
