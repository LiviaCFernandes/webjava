package entity;

import java.io.Serializable;

public class Pessoa implements Serializable{

		private Long id;
		private String nome;
		private Integer idade;
		
		public Pessoa() {
		}
			
		public Pessoa(Long id, String nome, Integer idade) {
			super();
			this.id = id;
			this.nome = nome;
			this.idade = idade;
		}
		
		@Override
		public String toString() {
			return "Pessoa [id=" + id + ", nome=" + nome + ", idade=" + idade + "]";
		}

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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
		
		//polimorfismo
		public String definirClasse() {
			return "SuperClasse Pessoa";	
		}
		
		public static void main(String[] args) {
			//trabalha com construtor cheio
			Pessoa x = new Pessoa(10L,"beira",16);
			System.out.println(x);
			System.out.println("------");
			
			//trabalha com construtor vazio
			Pessoa p=new Pessoa();
			//p objeto Pessoa
			p.setId(10L);
			p.setNome("lu");
			p.setIdade(20);
			
			System.out.println(p.getId() + "," + p.getNome() + "," + p.getIdade());
		}
		
}
