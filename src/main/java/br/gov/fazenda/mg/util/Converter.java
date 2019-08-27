/**
 * 
 */
package br.gov.fazenda.mg.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * @author claudiney.viana
 *
 */
public class Converter {
	
	
	/**
	 * M�todo que converte java.util.Date para String no formato Firebird
	 * @param data
	 * @return String
	 */
	public static String dateToStringDateSQL(Date data){
		java.sql.Date date = new java.sql.Date(data.getTime());
		return date.toString().replace("-", ".");		
	}
	
		
	/**
	 * M�todo que converte java.sql.Date para String
	 * @param data
	 * @return String
	 */
	public static String dateSqlToDateString(java.sql.Date data){	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		return sdf.format(data); 		
	}	
	
	/**
	 * M�todo que formata casa decimal no BigDecimal
	 * @param item
	 * @param fraction
	 * @return
	 */
	public static BigDecimal formataCasaDecimalBigDecimal(BigDecimal item, int fraction){
		  NumberFormat nf = NumberFormat.getInstance(new Locale("pt_br")); 
			nf.setMinimumFractionDigits(fraction);       				
			return new BigDecimal(nf.format(item).replace(",", ""));	   
	}
		
	public static BigDecimal numeroStringToBigDecimalFormatt(String num) throws ParseException{	
		if(num == null || num.equals("")){
			return new BigDecimal("0.00");
		}
		DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));
        df.setParseBigDecimal (true);
        df.setMinimumFractionDigits(2);
        BigDecimal b1 = null;
        try {
			b1 = (BigDecimal) df.parse (num);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ParseException(e.getMessage(), 0);
		}
		return b1;
	}
	
	/**
	 * M�todo que converte Date para String
	 * @param data
	 * @return String
	 */
	public static String dateToString(Date data){		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		return sdf.format(data); 		
	}
}