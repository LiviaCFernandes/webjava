package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Comprador implements Serializable{
	
	private String nome;
	private Integer idade;
	//1pN
	private List <Ingresso> ingressos;
		
	public Comprador() {
	}
	
	public Comprador(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "aeoh [nome=" + nome + ", idade=" + idade + "]";
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	//public void comprarIngresso (Ingresso ...i) {
	//	if(ingressos==null) {
		//	ingressos = new ArrayList<Ingresso>();
		//}
		//ingressos.add(Arrays.asList(i));
//	}
	
	

}
