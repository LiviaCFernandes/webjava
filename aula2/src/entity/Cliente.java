package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 3L;

	private Integer id;
	private String nome;
	private String email;
	//1pN
	private List <Telefone> telefones;
	
	
	
	public Cliente() {
	}

	public Cliente(Integer id, String nome, String email) {;
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
		
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	public void adicionarTelefone(Telefone ...t) {
		if(telefones==null) {
			telefones = new ArrayList<Telefone>();
		}
		telefones.addAll(Arrays.asList(t));
	}
	
	public Telefone buscarTelefone(Telefone t) {
		Telefone y = telefones.stream().filter(x->x.getNumero().equals(t.getNumero())).findAny().orElse(null);
		if (y==null)
			System.out.println("Não Encontrado");
		else
			System.out.println("Encontrado");
		return y;
	}
	
	public static void main(String[] args) {
		Cliente c1 = new Cliente (1000, "felipe", "felipe@gmail.com");
		Cliente c2 = new Cliente (2000, "renata", "renata@gmail.com");
		Telefone t1 = new Telefone (10, "981990101","vivo", 200.);
		Telefone t2 = new Telefone (20, "981990102","claro", 350.);
		
		c1.adicionarTelefone(t1,t2);
		
		Telefone t3 = new Telefone (30, "981990103","oi", 200.);
		Telefone t4 = new Telefone (40, "981990104","tim", 250.);
		
		c2.adicionarTelefone(t3,t4);
		
		System.out.println(c1);
		System.out.println(c1.getTelefones());
		System.out.println(c2);
		System.out.println(c2.getTelefones());
		
		Telefone t5 = new Telefone (null, "981990105", null, null);
		Telefone resposta = c1.buscarTelefone(t5);
		System.out.println("Telefone encontrado: " +resposta);
	}	
}
