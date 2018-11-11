package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Usuario;

public class UsuarioDao extends Dao {

	public void create(Usuario u) throws Exception{
		open();
		stmt = con.prepareStatement("insert into usuario values(null,?,?)");
			stmt.setString(1, u.getLogin());
			stmt.setString(2, u.getSenha());
			stmt.execute();
			stmt.close();
		close();
	}
	
	public void update(Usuario u) throws Exception{
		open();
		stmt = con.prepareStatement("update usuario set login=?, senha=? where id=?");
			stmt.setString(1, u.getLogin());
			stmt.setString(2, u.getSenha());
			stmt.setInt(3, u.getId());
			stmt.execute();
		stmt.close();
		close();
	}
	
	public void delete(Integer cod) throws Exception{
		open();
		stmt = con.prepareStatement("delete from usuario where id=?");
			stmt.setInt(1, cod);
			stmt.execute();
		stmt.close();
		close();
	}
	
	public List<Usuario> findAll() throws Exception{
		open();
		stmt = con.prepareStatement("select * from usuario");
			rs = stmt.executeQuery();
			List<Usuario> lst = new ArrayList<Usuario>();
			while(rs.next()) {
				Usuario u = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3));
				lst.add(u);				
			}
		close();
		return lst;
	}
	
	public Usuario findByCode(Integer cod) throws Exception{
		open();
		stmt = con.prepareStatement("select * from usuario where id=?");
			stmt.setInt(1, cod);
			rs = stmt.executeQuery();
			Usuario usuario = null;
			if(rs.next()) {
				usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		close();
		return usuario;
	}
	
	public Usuario findByLogin(Usuario u) throws Exception{
		open();
		stmt = con.prepareStatement("select * from usuario where login=? and senha=?");
			stmt.setString(1, u.getLogin());
			stmt.setString(2, u.getSenha());
			rs = stmt.executeQuery();
			Usuario usuario = null;
			if(rs.next()) {
				usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		close();
		return usuario;
	}
	
	
}
