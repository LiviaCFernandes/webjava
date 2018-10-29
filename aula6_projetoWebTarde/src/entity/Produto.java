package entity;

import java.io.Serializable;

public class Produto implements Serializable {
	
	private Integer idProduto;
	private String nome;
	private Double preco;
	
		
	public Produto() {
	}
	
	public Produto(Integer idProduto, String nome, Double preco) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.preco = preco;
	}
		
	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", preco=" + preco + "]";
	}

	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
}
