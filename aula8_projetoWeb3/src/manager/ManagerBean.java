package manager;

import java.util.List;

import entity.Usuario;
import persistence.UsuarioDao;

public class ManagerBean {
	
	private List<Usuario> usuarios;
	
	public List<Usuario> getUsuarios(){
		try {
			usuarios = new UsuarioDao().findAll();
		}catch(Exception ex) {
			
		}
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios){
		this.usuarios = usuarios;
	}
}
