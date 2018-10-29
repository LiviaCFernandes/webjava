package exercicioRevisao;

public class Estagiario extends Funcionario {
	//estagio é funcionario - herança
	//ter funcionario tem dependentes - relacionamento

	@Override
	public void calcularAcrescimo() throws Exception{
		if (getSalario()==null) {
			throw new Exception ("Salario nao pode estar vazio");
		}
		setAdicional ((getSalario() * 10.)/100);
		setSalario (getSalario () + getAdicional());//salario final		
	}

}
