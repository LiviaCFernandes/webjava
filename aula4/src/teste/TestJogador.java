package teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

import entity.Jogador;

public class TestJogador {
	
	private Jogador jogador;
	
	@Before()
	public void init() {
		this.jogador = new Jogador();
	}
	
	@Test()
	public void testarIdNull() {
		this.jogador.setIdJogador(null);
		assertNotNull("Nome é null", this.jogador.getIdJogador());
	}
	
	@Test()
	public void testarLimiteSuperior() {
		this.jogador.setNome("sdsadsad ");
		assertTrue("Nome nao esta na faixa até 70 letras: ", this.jogador.getNome().length()<=70);
	}
	
	@Test()
	public void testarConteudoNome() {
		this.jogador.setNome("belem10");
		Pattern p = Pattern.compile("[a-z A-Z]+");
		Matcher m = p.matcher(this.jogador.getNome());
		assertTrue("On nome não pode ter nº ou simbolos", m.matches());
	}
	
}
