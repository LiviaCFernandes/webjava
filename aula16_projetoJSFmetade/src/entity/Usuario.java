package entity;
//projeto com jsf
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	// é o auto_inclement do proprio java
	private final AtomicInteger count = new AtomicInteger(0);

	private Integer id;
	private String login;
	private String senha;
	private Integer pontos = 0; // dificil=15, inter=10, facil=5

	private List<Chamado> lista;

	public Usuario() {
		this.id = count.incrementAndGet();
	}

	public Usuario(Integer id, String login, String senha, Integer pontos) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.pontos = pontos;
	}

	public void incrementa() {
		this.id = count.incrementAndGet();
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<Chamado> getLista() {
		return lista;
	}

	public void setLista(List<Chamado> lista) {
		this.lista = lista;
	}

	public AtomicInteger getCount() {
		return count;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public void adicionar(Chamado c) {
		if (lista == null) {
			lista = new ArrayList<Chamado>();
		}
		lista.add(c);
	}

}
