package entity;

import java.util.Date;

public class Funcionario {

	private Integer idFuncionario;
	private String nome;
	private Date dataAdmissao;
	
		
	public Funcionario() {
	}

	public Funcionario(Integer idFuncionario, String nome, Date dataAdmissao) {
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
	}
		
	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", nome=" + nome + ", dataAdmissao=" + dataAdmissao
				+ "]";
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	
}
