package manager;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import entity.Chamado;
import entity.Usuario;

@ManagedBean(name = "mb")
@RequestScoped
public class ManagerBean {

	public List<Usuario> usuarios;
	private Usuario usuario;
	
	private Integer dia=0;
	private Integer mes=0;
	private Integer ano=0;
	private String resolucao = "";

	public ManagerBean() {
		this.usuario = new Usuario();// espaco na memoria
		usuarios = new ArrayList<Usuario>();
		usuarios = Arrays.asList(new Usuario[] { new Usuario(100, "michel@gmail.com", "123", 0),
				new Usuario(101, "tompo@gmail.com", "123", 0), new Usuario(102, "gustavo@gmail.com", "abv", 0) });
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getResolucao() {
		return resolucao;
	}
	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}
	
	public String logar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		try {
			int flag = 0;
			for (Usuario u : this.usuarios) {
				if (this.usuario.getLogin().equals(u.getLogin()) & this.usuario.getLogin().equals(u.getLogin())) {
					Chamado ch = new Chamado();
						//chamado busca o usuario
						ch.setUsuario(this.usuario);
					session.setAttribute("usuario", this.usuario);
					session.setAttribute("chamado", ch);
					flag = 1;
					break;
				}
			}
			if (flag == 1) {
				fc.addMessage(null, new FacesMessage("Logado!"));
				return "logado";
			} else {
				fc.addMessage(null, new FacesMessage("Não logado"));
				return null;
			}
		} catch (Exception ex) {
			fc.addMessage(null, new FacesMessage("Não logado"));
			return null;
		}
	}

	public Boolean isChamado() {
		//validacao da classe
		if (this.resolucao.equalsIgnoreCase("concluido")) {
			return true;
		} else if (this.resolucao.equalsIgnoreCase("fazendo")) {
			return false;
		} else if (this.resolucao.equalsIgnoreCase("impedimento")) {
			return false;
		} else {
			throw new IllegalArgumentException("Não encontrado");
		}
	}

	public Long calcularPontos() {
		LocalDate dataEntrada = LocalDate.now();
		LocalDate dataSaida = LocalDate.of(this.ano, this.mes, this.dia);
		Period duracao = Period.between(dataEntrada, dataSaida);
		long tempo = duracao.getDays();
		if (tempo >= 5) {
			this.usuario.setPontos(this.usuario.getPontos() + 15);
		} else if (tempo >= 3 & tempo < 5) {
			this.usuario.setPontos(this.usuario.getPontos() + 10);
		} else {
			this.usuario.setPontos(this.usuario.getPontos() + 5);
		}
		return this.usuario.getPontos().longValue();
	}


	
}