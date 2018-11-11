package entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Chamado implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codigo;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private String resolucao; // (concluido, fazendo e impedimento)
	private String dificuldade;

	
	private Usuario usuario;

	public Chamado() {
		this.usuario = new Usuario();
	}

	public Chamado(Integer codigo, LocalDate dataEntrada, LocalDate dataSaida, String resolucao, String dificuldade) {
		this.codigo = codigo;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.resolucao = resolucao;
		this.dificuldade = dificuldade;
	}

	@Override
	public String toString() {
		return "Chamado [codigo=" + codigo + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida
				+ ", resolucao=" + resolucao + ", usuario=" + usuario + "]";
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getResolucao() {
		return resolucao;
	}

	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}
	

}
