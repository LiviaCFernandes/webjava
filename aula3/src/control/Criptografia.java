package control;

import org.jcommon.encryption.SimpleMD5;

import entity.Usuario;

public class Criptografia {
	//static significa alocado na mem
	//qnd static só trabalha com atributos statics
	static String palavra = "liviacfernandes@hotmail.com---1234567='1'='1'#!!!";	
			
	//não aceita nem this nem super	
	public static void criptografar(Usuario u){
		SimpleMD5 md5 = new SimpleMD5(u.getSenha(), palavra);
		//32 caracteres hexadeximal e criptografias
		String resp1 = md5.toHexString(); 
		u.setSenha(resp1);
	}
	
	public static void criptografarMonstro(Usuario u){
		// 8 criptografias		
		SimpleMD5 md5 = new SimpleMD5(u.getSenha(), palavra);
		String resp1 = md5.toHexString(); 
		
		SimpleMD5 md5b = new SimpleMD5("coti", palavra);
		String resp2 = md5b.toHexString(); 
		
		SimpleMD5 md5c = new SimpleMD5("java-jse", palavra);
		String resp3 = md5c.toHexString(); 
		
		SimpleMD5 md5d = new SimpleMD5("j-j", palavra);
		String resp4 = md5d.toHexString(); 
		
		SimpleMD5 md5e = new SimpleMD5("mobile", palavra);
		String resp5 = md5e.toHexString(); 
		
		SimpleMD5 md5f = new SimpleMD5("node", palavra);
		String resp6 = md5f.toHexString(); 
		
		SimpleMD5 md5g = new SimpleMD5("javinha", palavra);
		String resp7 = md5g.toHexString(); 
		
		SimpleMD5 md5h = new SimpleMD5("jse", palavra);
		String resp8 = md5h.toHexString(); 
		
		u.setSenha(resp1 + resp2 + resp3 + resp4 + resp5 +resp6 + resp7 + resp8);
	}
	
	public static void main(String[] args) {
		Usuario u = new Usuario();
			u.setId(10);
			u.setLogin("lu@gmail.com");
			u.setSenha("123");
		Criptografia.criptografarMonstro(u);
		System.out.println(u.getLogin() + "," + u.getSenha());
	}
}
