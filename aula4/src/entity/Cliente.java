package entity;

public class Cliente extends Pessoa {
	
	private Integer idCliente;
	private String nomePlano;
	private Double valorPlano;
	
		
	public Cliente() {
	}
	
	public Cliente(Integer idCliente, String nomePlano, Double valorPlano) {
		this.idCliente = idCliente;
		this.nomePlano = nomePlano;
		this.valorPlano = valorPlano;
	}	
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nomePlano=" + nomePlano + ", valorPlano=" + valorPlano + "]";
	}

	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomePlano() {
		return nomePlano;
	}
	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}
	public Double getValorPlano() {
		return valorPlano;
	}
	public void setValorPlano(Double valorPlano) {
		this.valorPlano = valorPlano;
	}
	
	
}
