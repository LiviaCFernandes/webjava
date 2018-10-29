package entity;

import java.io.Serializable;

public class Aluno implements Serializable {
	
		private Integer idAluno;
		private String nome;
		private String disciplina;
		private Double nota1;
		private Double nota2;
		private Double media;
		private String situacao;
		
				
		public Aluno() {
		}
		
		public Aluno(Integer idAluno, String nome, String disciplina, Double nota1, Double nota2) {
			this.idAluno = idAluno;
			this.nome = nome;
			this.disciplina = disciplina;
			this.nota1 = nota1;
			this.nota2 = nota2;
		}
				
		@Override
		public String toString() {
			return "Aluno [idAluno=" + idAluno + ", nome=" + nome + ", disciplina=" + disciplina + ", nota1=" + nota1
					+ ", nota2=" + nota2 + "]";
		}

		public Integer getIdAluno() {
			return idAluno;
		}
		public void setIdAluno(Integer idAluno) {
			this.idAluno = idAluno;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getDisciplina() {
			return disciplina;
		}
		public void setDisciplina(String disciplina) {
			this.disciplina = disciplina;
		}
		public Double getNota1() {
			return nota1;
		}
		public void setNota1(Double nota1) {
			this.nota1 = nota1;
		}
		public Double getNota2() {
			return nota2;
		}
		public void setNota2(Double nota2) {
			this.nota2 = nota2;
		}
		public Double getMedia() {
			return media;
		}
		public void setMedia(Double media) {
			this.media = media;
		}
		public String getSituacao() {
			return situacao;
		}
		public void setSituacao(String situacao) {
			this.situacao = situacao;
		}

		
		public void gerarMedia() throws Exception{
		      if(this.nota1<0 || this.nota1>10 || this.nota2<0 ||this.nota2>10 ){
		       throw new Exception("Nota(s) Invalida(s)");				 
		      }
		    this.setMedia((this.getNota1() +  this.getNota2())/2);
		    this.setSituacao((this.getMedia()>=7)?"Aprovado":"Reprovado");
		    
		    }
		
		public static void main(String[] args) {
			
			Aluno a = new Aluno();
			try {
				a.setIdAluno(100);
				a.setNome("livia");
				a.setDisciplina("java");
				a.setNota1(7.);
				a.setNota2(9.);
				a.gerarMedia();			
				System.out.println("Nome: " +a.getNome());
				System.out.println("Disciplina: " +a.getDisciplina());
				System.out.println("Media: " +a.getMedia());
				System.out.println("Situacao: " +a.getSituacao());
				
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

}
