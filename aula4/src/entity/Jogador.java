package entity;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Jogador implements Serializable {
	// nenhum campo pode ser null
	//regras: id<= 0 !! | null
	private Integer idJogador;
	// 2<letras>70 e esp<2 
	private String nome;
	//pontos <=10 ~ error 10~100 random
	private Integer pontos=0;
	
		
	public Jogador() {
	}

	public Jogador(Integer idJogador, String nome, Integer pontos) {
		this.idJogador = idJogador;
		this.nome = nome;
		this.pontos = pontos;
	}
	
	
	@Override
	public String toString() {
		return "Jogador [idJogador=" + idJogador + ", nome=" + nome + ", pontos=" + pontos + "]";
	}

	public Integer getIdJogador() {
		return idJogador;
	}
	public void setIdJogador(Integer idJogador) {
		this.idJogador = idJogador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getPontos() {
		return pontos;
	}
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
	
	public int gerarPontos() {
		int ponto = (int)(Math.random()*100);
		if (ponto<10) {
			return gerarPontos();
		}else {
			return ponto;
		}
	}

	public static void main (String[] args) {
		Jogador j = new Jogador();
			j.setNome("guilherme");
		System.out.println(j.gerarPontos());
	}
	
	public Boolean isNome() {
		if (this.getNome()==null)
			return false;
		Pattern p = Pattern.compile("[a-z A-Z]{2,70}");
		Matcher m = p.matcher(this.getNome());
			return m.matches();
	}
	
	public Boolean isIdJogador() {
		if (this.getIdJogador()==null)
			return false;
		if (this.getIdJogador()<=0) {
			return false;
		}else {
			return true;
		}
	}
}
