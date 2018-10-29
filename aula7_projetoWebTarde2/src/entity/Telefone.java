package entity;

import java.io.Serializable;

public class Telefone implements Serializable{
	
	private Integer idTelefone;
	private String operadora;
	private String numero;
	//Np1
	private Usuario usuario;
	
	
	public Telefone() {
	}

	public Telefone(Integer idTelefone, String operadora, String numero, Usuario usuario) {
		this.idTelefone = idTelefone;
		this.operadora = operadora;
		this.numero = numero;
		this.usuario = usuario;
	}
		
	@Override
	public String toString() {
		return "Telefone [idTelefone=" + idTelefone + ", operadora=" + operadora + ", numero=" + numero + "]";
	}

	public Integer getIdTelefone() {
		return idTelefone;
	}
	public void setIdTelefone(Integer idTelefone) {
		this.idTelefone = idTelefone;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
