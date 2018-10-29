package mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import entity.Usuario;

public class EnviarEmail {
	
	private static final String HOSTNAME="smtp.gmail.com";
	private static final String USERNAME="cotiexemplo@gmail.com";
	private static final String PASSWORD="@coticoti@";
  
	
  
  	public static Email conectaEmail()throws EmailException{
  		HtmlEmail mail = new HtmlEmail();
  			  mail.setHostName(HOSTNAME);
  			  mail.setSmtpPort(465);
  			  mail.setAuthentication(USERNAME, PASSWORD);
  			  mail.setTLS(true);
  			  mail.setSSL(true);
  			  mail.setFrom(USERNAME);
  		return mail;
  	}
	
  	public static String enviarEmail(Usuario u) throws EmailException{
  		HtmlEmail email = new HtmlEmail();
  			  email = (HtmlEmail)conectaEmail();
  			  email.setSubject("Ativar conta via Email" ); 
  			  email.addTo(u.getEmail());
  			  email.setCharset("utf-8");
  			  String msg= "<a href=http://localhost:8080/aula8_projetoWeb3/AtivarUsuario?email="+u.getEmail()+">"+"Ativar a Conta</a>";
  			  email.setMsg(msg);
  			  email.send();
  		return "Email Enviado com Sucesso";
  		
  	}
  	
}
