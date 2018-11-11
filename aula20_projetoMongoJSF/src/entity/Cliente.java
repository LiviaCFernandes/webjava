package entity;

import java.io.Serializable;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	private Double id;
	private String nome;
	private String email;
	private Double idade;
	
	
	public Cliente() {
	}
	
	public Cliente(Double id, String nome, String email, Double idade) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.idade = idade;
	}
		
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", idade=" + idade + "]";
	}

	public Double getId() {
		return id;
	}
	public void setId(Double id) {
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
	public Double getIdade() {
		return idade;
	}
	public void setIdade(Double idade) {
		this.idade = idade;
	}
	
	
}
