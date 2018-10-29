package entity;

import java.util.Date;

public class Movimentacao {
	
	private Integer idMovimentacao;
	private String operacao;
	private Double valor;
	private Date dataHora;
	
	public Movimentacao() {
	}
	
	public Movimentacao(Integer idMovimentacao, String operacao, Double valor, Date dataHora) {
		super();
		this.idMovimentacao = idMovimentacao;
		this.operacao = operacao;
		this.valor = valor;
		this.dataHora = dataHora;
	}
	
	@Override
	public String toString() {
		return "Movimentacao [idMovimentacao=" + idMovimentacao + ", operacao=" + operacao + ", valor=" + valor
				+ ", dataHora=" + dataHora + "]";
	}

	public Integer getIdMovimentacao() {
		return idMovimentacao;
	}
	public void setIdMovimentacao(Integer idMovimentacao) {
		this.idMovimentacao = idMovimentacao;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	

}
