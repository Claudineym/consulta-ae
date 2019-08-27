/**
 * 
 */
package br.gov.fazenda.mg.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author claudiney.viana
 *
 */
public class FileUtil {
			
	/*
	 * arguments setDomainEnv.bat in server WebLogic
	 */
	private static String resource = System.getProperty("imageLocation");
	private static String resNoticia = System.getProperty("noticiaLocation");
	private static String resNovidade = System.getProperty("novidadeLocation");
	
	public static String fileSeparator = System.getProperty("file.separator");	
	public static final String PATH = resource;	
	public static final String PATH_NOTICIA = resNoticia;
	public static final String PATH_NOVIDADE = resNovidade;
	
	/**
	 * M�todo para criar um arquivo. Verifica se j� existe o mesmo e o remove
	 * @param pathFile
	 * @throws IOException 
	 */
	public static File createFile(String pathFile) throws IOException{
		File file = new File(pathFile);		
		if(file.isFile()){
			file.delete();			
		}else{
			try {
				file.createNewFile();				
			} catch (IOException e) {
				//log.error("ERRO CREATE FILE "+e);
				throw new IOException("ERRO CREATE FILE: "+e);
			}
		}
		return file;
	}
	
	public static void createDirectory(String path) throws IOException{
		File file = new File(path);
		if(!file.isDirectory()){
			file.mkdir();
		}
	}
	
	/**
	 * M�todo que escreve Arquivo 
	 * @param fileName
	 * @param line
	 * @throws IOException
	 */
	public static void writeRegistro(String fileName, String line) throws IOException {
		FileOutputStream fileOutputStream = null;
		FileChannel fileChannel = null;
		ByteBuffer byteBuffer = ByteBuffer.allocate(line.length());
		try {
			File file = createFile(fileName);
			fileOutputStream = new FileOutputStream(file, false);  
			fileChannel = fileOutputStream.getChannel();
					
			byteBuffer.clear();
			byteBuffer.put((line).getBytes());
			byteBuffer.flip();
			while(byteBuffer.hasRemaining()) {
				fileChannel.write(byteBuffer);
			}
		} catch (IOException e) {
			//log.error("ERRO WRITE REGISTRO: "+e);
			throw new IOException("ERRO WRITE REGISTRO: "+e);
		} finally {
			if(fileChannel != null && fileOutputStream != null){
				fileChannel.close();
				fileOutputStream.close();
			}
		}
	}
	
	public static void writeFile(String fileName, byte[] b) throws IOException {
		FileOutputStream fileOutputStream = null;
		FileChannel fileChannel = null;
		ByteBuffer byteBuffer = ByteBuffer.allocate(b.length);
		try {
			File file = createFile(fileName);
			fileOutputStream = new FileOutputStream(file, false);  
			fileChannel = fileOutputStream.getChannel();
					
			byteBuffer.clear();
			byteBuffer.put(b, 0 , b.length);
			byteBuffer.flip();
			while(byteBuffer.hasRemaining()) {
				fileChannel.write(byteBuffer);
			}
		} catch (IOException e) {
			throw new IOException("ERRO WRITE REGISTRO: "+e);
		} finally {
			if(fileChannel != null && fileOutputStream != null){
				fileChannel.close();
				fileOutputStream.close();
			}
		}
	}
	
	public static void writeArquivoUTF8(String fileName, String content) throws IOException{
		OutputStreamWriter bufferOut = null;
		try {
			File file = createFile(fileName);
			bufferOut = new OutputStreamWriter(new FileOutputStream(file, false),"UTF-8");		
			bufferOut.write(content);
		} catch (IOException e) {
			//log.error("ERRO WRITE ARQUIVO UTF-8: "+e);
			throw new IOException("ERRO WRITE ARQUIVO UTF-8: "+e);
		} finally {
			if(bufferOut != null){ bufferOut.close(); }
		}
	}
		
	/**
	 * M�todo para deletar arquivos
	 * @param pathFile
	 * @throws IOException
	 */
	public static void deleteFile(String pathFile) throws IOException{		
		File file = new File(pathFile);		
		if(file.isFile()){
			file.delete();
		}
	}
	/**
	 * M�todo para listar os arquivos de um diret�rio
	 * @param resource 
	 */
	public static List<File> listFiles(String resource){		
		return Arrays.asList(new File(resource).listFiles());		
	}
	/**
	 * M�todo que lista os arquivos por Data e Hora de cria��o  na ordem decrescente
	 * @return List<File>
	 */
	public static List<File> listFilesOrderByDateTime(File diretorio){
		//File diretorio = new File(PATH_NOTICIA+NoticiaService.PUBLICADO);	
		
		if(!diretorio.isDirectory()){
			diretorio.mkdir();
		}
		
		List<File> files = Arrays.asList(diretorio.listFiles());		
		//Descending order
		Collections.sort(files ,Collections.reverseOrder(new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				long date1 = o1.lastModified();
				long date2 = o2.lastModified();
				  
				if (date1 > date2)
				return 1;
				else if (date2 > date1)
				return -1;
				  
				return 0;
			}
		}));
		List<File> listFile = new ArrayList<File>();
		for(File file : files){
			if(file.isFile()){
				listFile.add(file);
			}
		}		
		return listFile;
	}
	/**
	 * M�todo para mover arquivos
	 * @param fileOrigem
	 * @param fileDestino
	 * @throws IOException
	 */
	public static void moveFile(String fileOrigem, String fileDestino) throws IOException{
		File origem = new File(fileOrigem);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(origem);
			bis = new BufferedInputStream(fis);
			
			File destino = new File(fileDestino);
			FileOutputStream fos = new FileOutputStream(destino);
			bos = new BufferedOutputStream(fos);
			
			int i = -1;

			do {
				i = bis.read();

				if(i != -1) bos.write(i);

				} while(i !=-1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//log.error("ERRO MOVE FILE: "+e);
			throw new FileNotFoundException("ERRO MOVE FILE: "+e);
		} catch (IOException e) {
			e.printStackTrace();
			//log.error("ERRO MOVE FILE: "+e);
			throw new IOException("ERRO MOVE FILE: "+e);
		} finally{
			try {
				if(bis != null && bos != null){
					bos.close();
					bis.close();					
				}
			} catch (IOException e) {				
				//log.error("ERRO MOVE FILE: "+e);
				throw new IOException("ERRO MOVE FILE: "+e);
			}
		}
	}
	/**
	 * M�todo que le o arquivo
	 * @param pathFile
	 * @return
	 */
	public static String readerFile(String pathFile){
		BufferedReader br = null;
		StringBuilder rFile = new StringBuilder();
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(pathFile));
			while ((sCurrentLine = br.readLine()) != null) {
				rFile.append(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return rFile.toString();
	}
	
	public static String readerFileUTF8(String pathFile)throws Exception{
		StringBuffer bufSaida = new StringBuffer();		
		BufferedReader br;
		try {			
			br = new BufferedReader(new InputStreamReader(new FileInputStream(pathFile), "UTF-8"));						
			String linha;
			while( (linha = br.readLine()) != null ){
				bufSaida.append(linha + "\n");
			}
			br.close();
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
			throw new Exception(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception(e);
		}		
		return bufSaida.toString();		
	}	
	
	public String parseFile(InputStream is) throws Exception{		
		StringBuffer bufSaida = new StringBuffer();		
		BufferedReader br;
		try {			
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));			
			String linha;
			while( (linha = br.readLine()) != null ){
				bufSaida.append(linha + "\n");
			}
			br.close();
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
			throw new Exception(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception(e);
		}		
		return bufSaida.toString();		
	}	

}
