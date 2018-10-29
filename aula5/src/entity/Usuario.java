package entity;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private Integer id;
	private String nome;
	private String email;
	private String perfil;
	
		
	public Usuario() {
	}
	
	public Usuario(Integer id, String nome, String email, String perfil) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.perfil = perfil;
	}
		
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", perfil=" + perfil + "]";
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
}
