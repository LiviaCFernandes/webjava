package io;

import java.util.List;

import entity.Usuario;

public interface IArquivo {

	public void abrirArquivo() throws Exception;
	public void escreverUsuarios(List <Usuario> usuarios) throws Exception;	
	public void fecharArquivo() throws Exception;

}
