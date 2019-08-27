package br.gov.fazenda.mg.util;

public class TesteData {

	public static void main(String[] args) {
		/*// TODO Auto-generated method stub
		String data = "31/01/2014";
		SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {

		    String reformattedStr = myFormat.format(fromUser.parse(data));
		    System.out.println(reformattedStr);
		} catch (ParseException e) {
		    e.printStackTrace();
		}*/
		
		/*String ende = "FAZENDA CRYSTAL - KM 11,8,  SN";	
		
		int indexVirgulaNum = ende.lastIndexOf(",");
		System.out.println(ende.substring(indexVirgulaNum+1, ende.length()).trim());
		
		String logra = ende.substring(0, indexVirgulaNum);
		String numLogra = ende.substring(indexVirgulaNum+1, ende.length()).trim();*/
		
		/*String muni = "3159803 - SANTA VITORIA";
		
		System.out.println(muni.substring(0, muni.indexOf("-")));
		System.out.println(muni.substring(muni.indexOf("-")+1, muni.length()).trim());*/
		
		/*String paisEmit = "1058 - BRASIL";
		int indexTracoPaisEmit = paisEmit.indexOf("-");
		System.out.println("cod pa�s: "+paisEmit.substring(0, indexTracoPaisEmit).trim());
		System.out.println(paisEmit.substring(indexTracoPaisEmit+1));*/
		
		String codRegTrib = "3 - Regime Normal";
		
		System.out.println(codRegTrib.substring(0, codRegTrib.indexOf("-")).trim());
				
		
	}

}
