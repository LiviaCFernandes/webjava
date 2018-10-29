package entity;

import java.io.Serializable;

public class Usuario implements Serializable{
//1p1
	//DTO
	//JDBC
	
	private Integer IdUsuario;
	private String nome;
	private String email;
	
	private Endereco endereco;
	
	public Usuario() {
	}
	
		
	public Usuario(Integer idUsuario, String nome, String email, Endereco endereco) {
		IdUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
	}
	
	public Usuario(Integer idUsuario, String nome, String email) {
		super();
		IdUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [IdUsuario=" + IdUsuario + ", nome=" + nome + ", email=" + email + "]";
	}

	public Integer getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		IdUsuario = idUsuario;
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
	
	
}
