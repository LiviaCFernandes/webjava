package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Usuario implements Serializable {

	private Integer id;
	private String nome;
	private String email;
	private Integer ativo=0;
	//1pN
	private List<Telefone> telefones;
	
	public Usuario() {
	}
	
	public Usuario(Integer id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
		
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + "]";
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
	public Integer getAtivo() {
		return ativo;
	}
	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	//Sobrecarga de Métodos
	public void adicionar(Telefone t) {
		if(telefones==null) {
			telefones = new ArrayList<Telefone>();
		}
		telefones.add(t);
	}
	//n telefones pra 1 pessoa
	public void adicionar(Telefone ...t) {
		if(telefones==null) {
			telefones = new ArrayList<Telefone>();
		}
		telefones.addAll(Arrays.asList(t));
	}
}
