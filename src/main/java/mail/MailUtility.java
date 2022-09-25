package mail;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import java.util.*;
/**
 * @author gregoriosaggese
 *
 */

/**
 * Classe che definisce <i>MailUtility</i> 
 */
public class MailUtility {
	/**
	 * costruttore vuoto
	 */
	public MailUtility() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * metodo che crea un muovo messaggio e-mail, una nuova sessione con autenticator ,aggiunge un allegato alla e-mail e la invia usando le credenziali di impostate nel web.xml
	 * e nella servlet InviaQuestionario
	 */
	public static void sendEmail(String host, String port,
			final String userName, final String password, File file) throws AddressException,
	MessagingException, IOException {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		Session session = Session.getInstance(properties, auth);
		// creates a new e-mail message
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { 
				new InternetAddress("saggesegregorio@gmail.com") 
		};
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject("Questionari");
		msg.setSentDate(new Date());
		Multipart multipart = new MimeMultipart();
		BodyPart bodyPart = new MimeBodyPart();
		((MimeBodyPart) bodyPart).setText("Questionario", "ISO-8859-15");
		multipart.addBodyPart( bodyPart );
		String nomeFile = "Questionario";   // Il nome con cui si vuole che l'allegato venga visto
		bodyPart = new MimeBodyPart();
		((MimeBodyPart) bodyPart).attachFile(file);
		bodyPart.setFileName( nomeFile );
		multipart.addBodyPart( bodyPart );
		// Aggiungo il Multipart al messaggio
		msg.setContent(multipart);
		Transport.send(msg);
	}
}
