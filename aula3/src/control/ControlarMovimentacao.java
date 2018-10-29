package control;

import java.util.Date;

import entity.Correntista;
import entity.Movimentacao;

public class ControlarMovimentacao {

	public void depositar(Movimentacao m, Correntista c) throws Exception {
		if (c.getSaldo()==null || m.getValor()==null)
			throw new Exception ("Não pode ser Null, Exception");
		if (m.getValor()<0)
			throw new Exception ("Não pode deposito negativo");
		if (m.getOperacao().equalsIgnoreCase("deposito")) {
			c.setSaldo(c.getSaldo() + m.getValor());
		}
	}
	
	public void retirada(Movimentacao m, Correntista c) throws Exception {
		if (c.getSaldo()==null || m.getValor()==null)
			throw new Exception ("Não pode ser Null, Exception");
		if (m.getValor()<0)
			throw new Exception ("Não pode retirar  um valor negativo");
		if (m.getOperacao().equalsIgnoreCase("retirada")) {
			if (m.getValor()<=c.getSaldo()) {
				c.setSaldo(c.getSaldo() - m.getValor());
			}else {
				throw new Exception ("Não há saldo suficiente");
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			Correntista co = new Correntista (100, "lu@gmail.com", "123", "lu", 10000.);
			Movimentacao mo = new Movimentacao (1000, "deposito", 5000., new Date());
			ControlarMovimentacao com = new ControlarMovimentacao();
				com.depositar(mo, co);
			System.out.println(co.getNome() + "," + co.getSaldo());
			System.out.println(mo);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
