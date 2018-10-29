package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Usuario;

public class UsuarioDao extends Dao{
	
	public void create(Usuario u) throws Exception{
		open();
		stmt = con.prepareStatement("insert into usuario values(seq_usuario.nextval,?,?,0)");
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getEmail());
			stmt.execute();
		stmt.close();
		close();
	}
	
	public void ativa(Usuario u) throws Exception{
		open();
		stmt = con.prepareStatement("update usuario set ativo=1 where email=?");
			stmt.setString(1, u.getEmail());
			stmt.execute();
		stmt.close();
		close();
	}
	
	public List<Usuario> findAll() throws Exception{
		open();
		stmt = con.prepareStatement("select * from usuario where ativo=1");
		List<Usuario> lista = new ArrayList<Usuario>();
		rs = stmt.executeQuery();
		while (rs.next()) {
			Usuario u = new Usuario();
				u.setId(rs.getInt(1));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setAtivo(rs.getInt("ativo"));
				lista.add(u);
		}
		close();
		return lista;
	}
}
