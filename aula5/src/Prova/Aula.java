package Prova;
//sinebte 1 espaço de memoria, logo o ultimo inserido.
public class Aula {

	private String nome;
	
	private static Aula aula = null;
	
	private Aula() {
		
	}
	
	static Aula getInstance() {
		if(aula==null) {
			aula= new Aula();
		}else {
			System.out.println("java preenchido, aula tem espaço");
		}
		return aula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static void main(String[] args) {
		Aula x = Aula.getInstance();
		x.setNome("patri");
		System.out.println(x.getNome());
		x = Aula.getInstance();//não muda de espaço
		x.setNome("patri2");//sobrescreve
		System.out.println(x.getNome());
	}
	
}
