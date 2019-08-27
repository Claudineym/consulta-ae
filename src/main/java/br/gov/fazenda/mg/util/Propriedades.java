/**
 * 
 */
package br.gov.fazenda.mg.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.log4j.Logger;


/**
 * @author claudiney.viana
 *
 */
public class Propriedades {
	
	private static Properties props;	
	private static final String FILE_NAME_ADM = "/admBR.properties";
	private Logger log = Logger.getLogger(Propriedades.class);
	private String resource = System.getProperty("connFtpFileLocation");//-DimageLocation
			
	public Propriedades(){}	
		
	public Propriedades lerArquivoPropriedadesAdm(){		
		File diretorio = new File(resource + FILE_NAME_ADM);	
		if(diretorio.isFile()){ 
			try {				
				Reader reader = new FileReader(diretorio); 
				props = new Properties();
				props.load(reader);
				reader.close();				
			} catch (IOException e) {
				e.printStackTrace();
				log.error("ERRO PROPRIEDADES ADM: "+e.getMessage());
			}			
		}
		return this;
	}
	
	public Propriedades inserirValor(String key, String value) throws IOException {
		try {
			props.setProperty(key, value);
			props.store(new FileOutputStream(resource + FILE_NAME_ADM), null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.error("ERRO PROPRIEDADES ADM Arquivo n�o existe: "+e.getMessage());
			throw new FileNotFoundException("Arquivo n�o existe: "+ e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			log.error("ERRO PROPRIEDADES ADM Erro leitura/escrita: "+e.getMessage());
			throw new IOException("Erro leitura/escrita: "+e.getMessage());
		}
		return this;
	}
	
	public String lerValor(String key){		
		return props.getProperty(key);			
	}	
	
	/**
	 * 
	 * @param chave chave para consulta.
	 * 
	 * @return Valor da correspondente chave
	 */
	public String getContent(String chave) {		
		return props.getProperty(chave).trim();
	}

	public static Properties getProps() {
		return props;
	}

	public static void setProps(Properties props) {
		Propriedades.props = props;
	}		
}