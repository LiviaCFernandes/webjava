package exercicioRevisao;

public class Main {

	public static void main (String[] args) {
		try {
			Funcionario f[] = new Funcionario[3];
			f[0] = new Estagiario();
				f[0].setNome("beira");
				f[0].setSalario(400.);
				f[0].setFuncao("informatica");
				f[0].calcularAcrescimo();
			f[1] = new Programador();
				f[1].setNome("bel");
				f[1].setSalario(2000.);
				f[1].setFuncao("programador jr");
				f[1].calcularAcrescimo();
			f[2] = new Programador();
				f[2].setNome("lu");
				f[2].setSalario(8000.);
				f[2].setFuncao("gerente de projeto");
			System.out.println(f[0]);
			System.out.println(f[1]);
			System.out.println(f[2]);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}finally {
			System.out.println("Fim depois do try ou catch");
		}
	}
}
