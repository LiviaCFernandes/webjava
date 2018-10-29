package mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import entity.Message;

public class EnvioEmail {

	public static final String HOSTNAME = "smtp.gmail.com";
	public static final String QUEMENVIA = "cotiexemplo@gmail.com";
	public static final String SENHA = "@coticoti@";

	public static Email conectaEmail() throws EmailException {
		Email mail = new SimpleEmail();
		mail.setHostName(HOSTNAME);
		mail.setSmtpPort(465);// porta do gmail
		mail.setAuthentication(QUEMENVIA, SENHA);
		mail.setTLS(true);
		mail.setSSL(true);
		mail.setFrom(QUEMENVIA);
		return mail;
	}

	public static String enviarEmail(Message m) throws EmailException {
		try {
			Email mail = new SimpleEmail();
			mail = conectaEmail();
			for (int i = 1; i <= 3; i++) {
				mail.setSubject("Você acaba de ganhar um doce! Virou ativo");
				mail.addTo(m.getPara());
				mail.setMsg("Seja bem-vindo!");
				mail.send();
			}
			return ("Email enviado com sucesso!");
		}catch (Exception ex) {
			return ("Error: "+ex.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try {
			Message m = new Message();
			m.setPara("lucianamedeiros.coti@gmail.com");
			m.setAssunto("Aula de android a noite");
			m.setMenssage("Venha para 1 aula experimental!");
			EnvioEmail.enviarEmail(m);
			System.out.println("Email enviado");
		}catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
	}
}
