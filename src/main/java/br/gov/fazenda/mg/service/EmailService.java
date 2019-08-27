/**
 * 
 */
package br.gov.fazenda.mg.service;

import java.util.Date;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author claudiney.viana
 *
 */
@Service("emailService")
@Transactional(readOnly = true)
public class EmailService {	
	
	private MimeMessage msg;
	@PostConstruct
	private void init(){
		configHostSmtp();
	}
	
	public void sendMailToDeveloper(String subject, String content) throws Exception {
			try {
			msg.setFrom(new InternetAddress("aemg@fazenda.mg.gov.br"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress("claudiney.viana@fazenda.mg.gov.br"));
			msg.setSentDate(new Date());						
			msg.setSubject(subject +" [Favor n�o responder este e-mail]");		
			//htmlPart.setContent(messageToUsuario(usuario.getNome(), usuario.getPassword(), urlToImage, urlToHtml), "text/html; charset=UTF-8");
							
			msg.setContent(content, "text/html; charset=UTF-8");
			
			Transport.send(msg);
		} catch (AddressException ex) {
			throw new Exception(ex);
		} catch (MessagingException e) {
			throw new Exception(e);
		}
	}
	
	private void configHostSmtp(){
		Properties prop = new Properties();		
		prop.put("mail.smtp.host", "mail4.fazenda.mg.gov.br");
		prop.put("mail.smtp.auth", true);
		Session session = Session.getInstance(prop, auth);
		
		msg = new MimeMessage(session);
		new MimeMultipart("alternative");
	} 
	
	private Authenticator auth = new Authenticator() {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("aemg", "Sr@e3f*2");
        }
    };   
}