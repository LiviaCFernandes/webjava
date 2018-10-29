package exercicioRevisao;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Dependente implements Serializable {
	
	public static DateTimeFormatter SDF = DateTimeFormatter.ofPattern ("dd/MM/yyyy hh:mm:ss");
	
	private Integer idDependente;
	private String nome;
	private LocalDate dataNascimento;
	
	
	public Dependente() {
	} 
	
	public Dependente(Integer idDependente, String nome, LocalDate dataNascimento) {
		this.idDependente = idDependente;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
		
	@Override
	public String toString() {
		return "Dependente [idDependente=" + idDependente + ", nome=" + nome + ", dataNascimento=" + dataNascimento
				+  SDF.format(dataNascimento) + "]";
	}

	public Integer getIdDependente() {
		return idDependente;
	}
	public void setIdDependente(Integer idDependente) {
		this.idDependente = idDependente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getIdade() {
		LocalDate hoje = LocalDate.now();
		LocalDate nascimento = this.dataNascimento;
		Period period = Period.between(nascimento, hoje);
		return period.getYears();
	}
	 
	public static void main(String[] args) {
	/*	Dependente d = new Dependente();
		d.setDataNascimento(LocalDate.of(1973, 01, 28));
		System.out.println(d.getIdade());
	*/
		Dependente d = new Dependente (100, "bel", LocalDate.of(2003, 8, 21));
		System.out.println(d.getNome() + "," + d.getIdade());
	}
	
	
}
