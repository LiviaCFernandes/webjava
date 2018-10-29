package exercicioRevisao;

public class Programador extends Funcionario{

	@Override
	public void calcularAcrescimo() throws Exception {
		if (getSalario()==null) {
			throw new Exception ("Salario nao pode estar vazio");
		}
		setAdicional ((getSalario() * 20.)/100);
		setSalario (getSalario () + getAdicional());//salario final			
	}

}
