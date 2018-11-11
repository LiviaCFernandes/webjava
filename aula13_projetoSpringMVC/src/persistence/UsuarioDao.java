package persistence;

import java.util.ArrayList;
import java.util.List;

import control.MD5;
import entity.Usuario;

public class UsuarioDao extends Dao{

	public void create(Usuario u) throws Exception{
		open();
		MD5.criptografia(u);
		stmt = con.prepareStatement("insert into usuario values (null,?,?,?)");
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getSenha());
		stmt.execute();
		close();
	}

	public List<Usuario> findAll() throws Exception{
		open();
		stmt = con.prepareStatement("select * from usuario");
			List<Usuario> lst = new ArrayList<>();
		rs = stmt.executeQuery();
		while (rs.next()) {
			Usuario u = new Usuario (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			lst.add(u);
		}
		close();
		return lst;
	}

	public Usuario findByLogin (Usuario usu) throws Exception{
		open();
		MD5.criptografia(usu);
		stmt = con.prepareStatement("select * from usuario where email=? and senha=?");
			stmt.setString(1, usu.getEmail());
			stmt.setString(2, usu.getSenha());
		Usuario resp = null;
		rs = stmt.executeQuery();
		while(rs.next()) {
			resp = new Usuario (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}
		close();
		return resp;
	}
	
	public static void main(String[] args) {
		try {
			UsuarioDao ud = new UsuarioDao();
			Usuario u = new Usuario (null, "liv", "liv@gmail.com","123");
			//new UsuarioDao().create(u); //gravar
			Usuario resp = ud.findByLogin(u); //buscar
			System.out.println("Dados Gravados" + u);
		}catch(Exception ex) {
			System.out.println("Error: " +ex.getMessage());
		}
	}
	
}
