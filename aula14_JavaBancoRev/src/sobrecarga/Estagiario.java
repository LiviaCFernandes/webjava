package sobrecarga;

public class Estagiario extends Funcionario{

	public Estagiario() {
		super(20);// ele puxa a heranca dele e muda com os 20
	}
	
	public void escrever() throws IllegalArgumentException { //só sobrescreve se o erro for mais fraco ou igual
																		//q da superclasse(funcionario)
		System.out.println("sobrescrita");
		
		Integer a = 100; //n(?) é objeto
		Integer b = new Integer (100);// é objeto inteiro
		
		if(a.equals(b)) {
			System.out.println("Sao iguais");
		}else {
			System.out.println("Sao diferentes");
		}
	}
	
	public static void main(String[] args) {
		Estagiario  e = new Estagiario();
		e.escrever();
		String s = "aula"; //objeto
		String x = new String ("aula"); //objeto inteiro
		if(s==x) {												//== : meio objeto objeto cheio(sempre errado)
			System.out.println("um");
		}
	}
}
