package entity;

import java.io.Serializable;

public class Telefone implements Serializable{
	private static final long serialVersionUID = 7L;
	
	private Integer idTelefone;
	private String numero;
	private String operadora;
	private Double valorPlano;
	//Np1
	private Cliente cliente;
	
		
	public Telefone() {
	}
	
	public Telefone(Integer idTelefone, String numero, String operadora, Double valorPlano) {
		this.idTelefone = idTelefone;
		this.numero = numero;
		this.operadora = operadora;
		this.valorPlano = valorPlano;
	}
	
	@Override
	public String toString() {
		return "Telefone [idTelefone=" + idTelefone + ", numero=" + numero + ", operadora=" + operadora
				+ ", valorPlano=" + valorPlano + "]";
	}

	public Integer getIdTelefone() {
		return idTelefone;
	}
	public void setIdTelefone(Integer idTelefone) {
		this.idTelefone = idTelefone;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	public Double getValorPlano() {
		return valorPlano;
	}
	public void setValorPlano(Double valorPlano) {
		this.valorPlano = valorPlano;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
