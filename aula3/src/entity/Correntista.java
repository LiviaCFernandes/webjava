package entity;

public class Correntista extends Usuario {
		
	private String nome;
	private Double saldo=0.;
	
		
	public Correntista() {
	}
	
	public Correntista(Integer id, String login, String senha, String nome, Double saldo) {
		super(id, login, senha);
		this.nome = nome;
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "Correntista [nome=" + nome + ", saldo=" + saldo + ", getId()=" + getId() + ", getLogin()=" + getLogin()
				+ ", getSenha()=" + getSenha() + "]";
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
}


