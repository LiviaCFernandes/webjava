package io;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import entity.Usuario;

public class Arquivo implements IArquivo {
	
	FileWriter fw;
	
	@Override
	public void abrirArquivo() throws Exception {
		// qnd colocar false = sobrescrita e qnd colocar true = continua(adiciona)
		fw = new FileWriter("/tmp/usuario.txt",false);
	}

	@Override
	public void escreverUsuarios(List<Usuario> usuarios) throws Exception {
		for(Usuario x : usuarios) {
			fw.write(x +"\n");
		}
		fw.flush();
	}

	@Override
	public void fecharArquivo() throws Exception {
		fw.close();
	}
	
	public static void main(String[] args) {
		Arquivo a = new Arquivo();
		try {
			a.abrirArquivo();
			
			List <Usuario> lista = new ArrayList <Usuario>();
				lista.add(new Usuario (10, "gustavo@gmail.com", "123"));
				lista.add(new Usuario (11, "renata@gmail.com", "123"));
				lista.add(new Usuario (12, "alex@gmail.com", "123"));
				lista.add(new Usuario (13, "livia@gmail.com", "123"));
			a.escreverUsuarios(lista);	
				
			a.fecharArquivo();
			System.out.println("Dados Gravados");
		}catch(Exception ex) {
			System.out.println("Error: " +ex.getMessage());
		}
	}

}
