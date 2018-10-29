package entity;

import java.io.Serializable;

public class Ingresso implements Serializable {
	
	private Integer idIngresso;
	private String numero;
	private String valor;
	//Np1
	private Comprador comprador;
	
		
	public Ingresso() {
	}

	public Ingresso(Integer idIngresso, String numero, String valor, Comprador comprador) {
		this.idIngresso = idIngresso;
		this.numero = numero;
		this.valor = valor;
		this.comprador = comprador;
	}
	
	@Override
	public String toString() {
		return "Ingresso [idIngresso=" + idIngresso + ", numero=" + numero + ", valor=" + valor + ", comprador="
				+ comprador + "]";
	}

	public Integer getIdIngresso() {
		return idIngresso;
	}
	public void setIdIngresso(Integer idIngresso) {
		this.idIngresso = idIngresso;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
}
