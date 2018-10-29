package persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import entity.Usuario;

public class UsuarioDao extends Dao {

	public void create(Usuario u) throws Exception {
		open();
		stmt = con.prepareStatement("insert into usuario values (null,?,?,0)");
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getEmail());
		stmt.execute();
		close();
	}

	public List<Usuario> findAll() throws Exception {
		open();
		stmt = con.prepareStatement("select * from usuario");
		rs = stmt.executeQuery();
		List<Usuario> lista = new ArrayList<Usuario>();
		while (rs.next()) {
			Usuario u = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3));
			u.setAtivo(rs.getInt(4));
			lista.add(u);
		}
		close();
		return lista;
	}

	public void activo(Usuario u) throws Exception {
		open();
		stmt = con.prepareStatement("select * from usuario where email=?");
			stmt.setString(1, u.getEmail());
		rs = stmt.executeQuery();
		if (rs.next()) {
			PreparedStatement stmt2 = con.prepareStatement("update usuario set ativo=1 where email=?");
				//stmt2.setInt(1, 1);
				stmt2.setString(1, u.getEmail());
			stmt2.execute();
			stmt2.close();
		}
		stmt.close();
		close();
	}
	
	public static void main(String[] args) {
		try {
			UsuarioDao dao = new UsuarioDao();
			Usuario u2 = new Usuario(null,"beira2","beira2@gmail.com");
			//dao.create(u2);
			//System.out.println(u2);
			dao.activo(u2);
			System.out.println(u2);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
