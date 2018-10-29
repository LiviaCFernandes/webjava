package control;

import java.util.ArrayList;
import java.util.List;

import entity.Usuario;

public class controleUsuario {

		private List <Usuario> usuarios;

		public List<Usuario> getUsuarios() {
			return usuarios;
		}

		public void setUsuarios(List<Usuario> usuarios) {
			this.usuarios = usuarios;
		}
		
		public void adicionar(Usuario u) {
			if (this.usuarios==null) {
				//Primeiro passo: é inserir espaço na memoria
				this.usuarios = new ArrayList<Usuario>();
			}
			this.usuarios.add(u);
		}
		
		public int quantidade() {	
			//como é lista é o 'size', se fosse vetor seria 'legth'
			return this.usuarios.size();
		}
		
		public Usuario busca(Usuario u) {
			//entrou no stream e filtrou dentro do login se tem o msm login, se encontrou retorna senao retorna vazio
			return this.usuarios.stream().filter(x->x.getLogin().equalsIgnoreCase(u.getLogin())).findAny().orElse(null);
		}
		
		public static void main(String[] args) {
			controleUsuario cont = new controleUsuario();
			Usuario u1=new Usuario (10, "beira", "123");
			Usuario u2=new Usuario (11, "felipe", "123");
			Usuario u3=new Usuario (12, "alex", "123");
			cont.adicionar(u1);
			cont.adicionar(u2);
			cont.adicionar(u3);
			System.out.println(cont.quantidade());
			
			Usuario buscar = new Usuario (null,"alex", null);
			System.out.println("Resultado da busca: " + cont.busca(buscar));
		}
}
