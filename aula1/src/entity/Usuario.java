package entity;

//superClasse(primeira classe)
//sub (Herança da SuperClasse)
public class Usuario extends Pessoa {

	private String login;
	private String senha;
	
	//construtor vazio
	public Usuario() {
	}
	
	// construtor cheio
	public Usuario(Long id, String nome, Integer idade, String login, String senha) {
		super(id, nome, idade);
		this.login = login;
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Usuario [login=" + login + ", senha=" + senha + ", getId()=" + getId() + ", getNome()=" + getNome()
				+ ", getIdade()=" + getIdade() + "]";
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	//Usuario é herança de Pessoa
	//Logo a sobrescrita passa a valer quando esse metodo da superclasse é exatamente igual
	//ao da subClasse(sobrescrita)==Polimorfismo!
	@Override
	public String definirClasse() {
		return "SubClasse Usuario";
	}
	
	public static void main(String[] args) {
		Usuario u = new Usuario (100L, "felipe", 19, "felipe@gmail.com", "123");
		Endereco e = new Endereco (200, "Av Rio Branco, 185", "Centro", "Rio de Janeiro", "RJ", "22240007");
		e.setPessoa(u);
		
		System.out.println(e.getPessoa()); //chama o toString de usuario da herança não de pessoa(sobrescrita)
		System.out.println(e);
		System.out.println(u.definirClasse());
	}
}
