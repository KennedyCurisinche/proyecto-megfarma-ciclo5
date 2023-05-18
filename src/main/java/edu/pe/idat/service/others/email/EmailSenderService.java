package edu.pe.idat.service.others.email;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	public void sendEmail(String documento, String correo, String nom, String cod,String ruta) {
		
		String correoEnvia = "megasfarmas@gmail.com";
		String contrasenia = "gbkdmjwlrunifzpy";
		String correoDestino = correo; // "rogger9081@gmail.com";

		// Iniciamos el protocolo smtp

		Properties properties = new Properties();

		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.user", correoEnvia);
		properties.setProperty("mail.smtp.auth", "true");
		
		
		// Inicia el proceso

		Session session = Session.getDefaultInstance(properties);
		
		String user = System.getProperty("user.name");	
		String rutadeterminada = rutaexistente(ruta, user);
		
		try {
			
			BodyPart ms = new MimeBodyPart();
			ms.setContent("<html>"
						+ "<body class='text-' style='text-align: center;'>"
					    + "<h1 lang='es' style='text-align: center;'>COMPROBANTE DE PAGO MEGAFARMA</h1>"
						+ "<strong lang='es'>RUC: </strong><p lang='es'>00000000000</p>"
						+ "<strong lang='es'>DNI: </strong><p lang='es'>" + documento + "</p>"
						+ "<strong lang='es'>NOMBRE: </strong><p lang='es'>" + nom + "</p>"
						+ "<strong lang='es'>CODIGO DE LA COMPRA: </strong><p>" + cod +"</p>"
						+ "<strong lang='es'>OJO: </strong><p>Con este codigo debera reclamar su pedido. Ten encuenta que debio adjuntar la captura del yape o plin, de lo contrario su compra sera revocada.</p>"
						+ "</body>"
						+ "</html>", "text/html");

			BodyPart adjunto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource(rutadeterminada)));
			adjunto.setFileName(ruta); // nombre del archivo que desea poner el usuario

			MimeMultipart m = new MimeMultipart();
			m.addBodyPart(ms);
			m.addBodyPart(adjunto);

			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(correoEnvia));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));
			message.setSubject("COMPRA REALIZADA - MEGAFARMA");
			message.setContent(m); // obtiene los valores ingresados

			// El envio

			Transport t = session.getTransport("smtp");
			t.connect(correoEnvia, contrasenia);
			t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			t.close();
			System.out.println("Correo enviado");
		} catch (AddressException ex) {
			ex.printStackTrace();
		} catch (MessagingException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String rutaexistente(String ruta, String user) {
		
		String op1 = "C:\\Users\\"+user+"\\Desktop\\"+ruta; //String op1 = "C:\\Users\\"+user+"\\Desktop\\"+ruta;
		String op2 = "C:\\Users\\"+user+"\\Pictures\\"+ruta;
		String op3 = "C:\\Users\\"+user+"\\Documents\\"+ruta;
		String op4 = "C:\\Users\\"+user+"\\Downloads\\"+ruta;
		
		//Boolean valor = ;
		
		File f1 = new File(op1);
		File f2 = new File(op2);
		File f3 = new File(op3);
		File f4 = new File(op4);
		
		String rutavalida = "";
		
		if (f1.exists()) {
			rutavalida = op1;
		}else if (f2.exists()) {
			rutavalida = op2;
		}else if (f3.exists()) {
			rutavalida = op3;
		}else if (f4.exists()) {
			rutavalida = op4;
		}
		
		return rutavalida;
	}
}

