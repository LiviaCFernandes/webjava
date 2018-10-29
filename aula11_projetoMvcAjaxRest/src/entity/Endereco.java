package entity;

import java.io.Serializable;

public class Endereco implements Serializable{

	private Integer idEndereco;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	
	private Usuario usuario;
	
	public Endereco() {
	}

	public Endereco(Integer idEndereco, String logradouro, String bairro, String cidade, String estado, String cep) {
		this.idEndereco = idEndereco;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
	
	
	
	//GoogleMaps 
	public String toString() {
		return this.logradouro + "," + this.bairro + "," + this.cidade + "," + this.estado + "," + this.cep;
	}
	
	public Integer getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
