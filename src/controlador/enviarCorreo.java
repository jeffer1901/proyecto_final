package controlador;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class enviarCorreo {
	private static String emailFrom="jeffersonrubiorincon@gmail.com";
	private static String contraseña="qkjr kgww fzsi mbgk";
	private static Properties properties=new Properties();
	private static MimeMessage mMessage;
	private static Session mSession;
	public static void enviarConfirmacion(String emailTo,String subject,String content) {
		
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.user",emailFrom);
		properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		properties.setProperty("mail.smtp.auth", "true");
		mSession=Session.getDefaultInstance(properties);
		
		mMessage =new MimeMessage(mSession);
		try {
			mMessage.setFrom(new InternetAddress(emailFrom));
			mMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
			mMessage.setSubject(subject);
			mMessage.setText(content,"ISO-8859-1","html");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void enviar() {
		try {
			Transport mTransport=mSession.getTransport("smtp");
			mTransport.connect(emailFrom,contraseña);
			mTransport.send(mMessage,mMessage.getRecipients(Message.RecipientType.TO));
			mTransport.close();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
