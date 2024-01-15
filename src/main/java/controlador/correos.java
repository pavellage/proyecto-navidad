package controlador;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//autor: Pavel Lage Santos
public class correos {

	public void mandarcorreo(Session session ,String mensaje,String origen, String destinatario ) {
		try {
		 MimeMessage msg = new MimeMessage(session);
	     msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	     msg.addHeader("format", "flowed");
	     msg.addHeader("Content-Transfer-Encoding", "8bit");
	     msg.setFrom(new InternetAddress(origen, "NoReply-JD"));
	     msg.setReplyTo(InternetAddress.parse(origen, false));
	     msg.setSubject(mensaje, "UTF-8");
	     msg.setText(mensaje, "UTF-8");
	     msg.setSentDate(new Date());
	     msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario, false));
	     System.out.println("Message is ready");
	     Transport.send(msg);
	     System.out.println("EMail Sent Succesfully!!");
	     
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		
	}
	//NoReply-JD
	public void prepararymandara(String destino, String mensaje) {
		
		final String fromEmail = "AAcorreoPruebas";
	       final String password ="qfhuoosrtehnkeck";
	       final String correo_destino = destino;
	  //alejandro.pernie@educa.jcyl.es 
	  //port587
	       
	       Properties props = new Properties();
	       props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.starttls.enable", "true");
	      // props.put("mail.smtp.socketFactory.port", "587");
	      // props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	       props.put("mail.smtp.auth", "true");
	       props.put("mail.smtp.ssl.protocols", "TLSv1.2");
	       props.put("mail.smtp.port", "587");
	       
	       
	      Authenticator auth;
	        auth = new Authenticator() {
	        
	            
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(fromEmail, password);
	            }
	        };
	        Session session = Session.getInstance(props, auth);

	    
	        mandarcorreo(session, mensaje, fromEmail, correo_destino);
		
		
		
		
	}
}
	
	
