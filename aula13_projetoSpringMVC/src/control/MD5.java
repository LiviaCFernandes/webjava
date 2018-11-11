package control;

import org.jcommon.encryption.SimpleMD5;

import entity.Usuario;

public class MD5 {

	public static void criptografia(Usuario u) {
		String palavra = "michelpqdOsubstituto@gmail.com,123456789%%$==1";
		SimpleMD5 md5 = new SimpleMD5(u.getSenha(), palavra);
		u.setSenha(md5.toHexString());
		
	}
	
	public static void main(String[] args) {
		Usuario u1 = new Usuario(10,"lu","lu@gmail.com","123");
		Usuario u2 = new Usuario(11,"gusta","gusta@gmail.com","123");
		MD5.criptografia(u1);
		MD5.criptografia(u2);
		System.out.println(u1);
		System.out.println(u2);
	}
}
