package entity;

public class Endereco {

	private Integer idEndereco;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	
	//relacionamento entre endereco com pessoa 
	//1p1
	private Pessoa pessoa;
	
	public Endereco() {
	}
	
	public Endereco(Integer idEndereco, String logradouro, String bairro, String cidade, String estado, String cep) {
		this.idEndereco = idEndereco;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", logradouro=" + logradouro + ", bairro=" + bairro + ", cidade="
				+ cidade + ", estado=" + estado + ", cep=" + cep + ", pessoa=" + pessoa + "]";
	}


	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	public static void main(String[] args) {
		Pessoa p = new Pessoa (100L,"jamal",21);
		Endereco e = new Endereco (185,"Av Rio Branco,185","Centro","Rio de Janeiro","RJ","22240007");
		e.setPessoa(p);// aq foi relacionado "o endereco corresponde a pessoa x"
		
		System.out.println("Pessoa --- " +e.getPessoa());//aq ele imprime pelo endereço por isso o "e" na frente
		System.out.println("Endereco --- " +e);
	}
	
}
