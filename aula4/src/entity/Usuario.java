package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Usuario implements Serializable, Comparable<Usuario>{
//ordenacao deve ser feita
//classe completa (java7)
	private Integer idUsuario;
	private String login;
	private String senha;
	
	
	public Usuario() {
	}
	
	public Usuario(Integer idUsuario, String login, String senha) {
		this.idUsuario = idUsuario;
		this.login = login;
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", login=" + login + ", senha=" + senha + "]";
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	//ORDENACAO
	@Override
	public int compareTo(Usuario u) {
		return this.idUsuario.compareTo(u.getIdUsuario());
	}//crescente this -> get
	// decrescente get -> this
	
	//BUSCA
	public boolean equals(Object o) {
		Usuario usu = (Usuario) o;
		if (this.getIdUsuario().equals(usu.getIdUsuario())){
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Usuario u1 = new Usuario(10, "livia@gmail","123");
		Usuario u2 = new Usuario(30, "alan@gmail","123");
		Usuario u3 = new Usuario(5, "alisson@gmail","123");
		Usuario u4 = new Usuario(6, "beira@gmail","123");
		if (u3.equals(u4)) {
			System.out.println("São iguais!");
		}else {
			System.out.println("São diferentes!");
		}
	
		List <Usuario> lista = new ArrayList<Usuario>();
			lista.add(u1);
			lista.add(u2);
			lista.add(u3);
			lista.add(u4);
			Collections.sort(lista); //ordenacao dos dados
			System.out.println(lista);
		
		Usuario busca = new Usuario(3,null,null);
		if (lista.contains(busca)) {
			int pos = lista.indexOf(busca);//indexof sempre da a posicao
			Usuario resposta = lista.get(pos);
			System.out.println("Encontrado! " +resposta);
		}else {
			System.out.println("Não encontrado! " +busca);
		}
	}
	
}
