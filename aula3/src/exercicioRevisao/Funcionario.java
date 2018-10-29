package exercicioRevisao;

import java.util.ArrayList;
import java.util.List;

public abstract class Funcionario {
	//classe abstrata -> sem precisar ter objeto
	
//se o cargo for estagiario, adicional de 10%
// programador, adicional de 20%
// gestor 0%
// a ideia de n gerar objeto é ser uma classe com intuito de herança
	private Integer idFuncionario;
	private String nome;
	private Double salario;
	private String funcao;
	private Double adicional=0.; // pode passar ou n construtor
	
	private List<Dependente> dependentes;


	public Funcionario() {
	}
	
	public Funcionario(Integer idFuncionario, String nome, Double salario, String funcao) {
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.salario = salario;
		this.funcao = funcao;
	}
	
	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", nome=" + nome + ", salario=" + salario + ", funcao="
				+ funcao + ", adicional=" + adicional + "]";
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

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Double getAdicional() {
		return adicional;
	}

	public void setAdicional(Double adicional) {
		this.adicional = adicional;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}
		
	public void adicionar(Dependente d) {
		if(dependentes==null) {
			dependentes = new ArrayList<Dependente>();
		}
		dependentes.add(d);
	}
	
	public abstract void calcularAcrescimo() throws Exception;
}
