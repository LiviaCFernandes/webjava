package dto;

import entity.Usuario;
import entity.Endereco;

public class DtoUsuarioEndereco {

	private Usuario usuario;
	private Endereco endereco;
	
	
	
	public DtoUsuarioEndereco() {
	}

	public DtoUsuarioEndereco(Usuario usuario, Endereco endereco) {
		this.usuario = usuario;
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		return "DtoUsuarioEndereco [usuario=" + usuario + ", endereco=" + endereco + "]";
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
}
