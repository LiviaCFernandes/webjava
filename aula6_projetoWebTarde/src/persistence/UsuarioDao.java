package persistence;

import entity.Usuario;

public class UsuarioDao extends Dao {
	
	public void gravar(Usuario u) throws Exception{
		open();
		//foi na tabela, inserir -> em cada ? é um comando embaixo.
		stmt = con.prepareStatement("insert into usuario values (null,?,md5(?),?)");
			//é a primeira informaçao, no primeiro ? q é o login
			stmt.setString(1, u.getLogin());
			//é a segunda informacao, no segundo ? q é a senha criptografada pelo md5
			stmt.setString(2, u.getSenha());
			stmt.setString(3, u.getAcesso());
		stmt.execute();
		stmt.close();
		close();
	}
	
	public Usuario logar(Usuario u) throws Exception{
		open();
		//esta pesquisando na tabela
		stmt = con.prepareStatement("select * from usuario where login=? and senha=md5(?)");
			stmt.setString(1, u.getLogin());
			stmt.setString(2, u.getSenha());
		// rs vai na tabela e executa a pesquisa
		rs = stmt.executeQuery();
		Usuario resposta = null;
		if (rs.next()) {
			resposta = new Usuario();
			resposta.setIdUsuario(rs.getInt(1));
			resposta.setLogin(rs.getString(2));
			resposta.setSenha(rs.getString(3));
		}
		stmt.execute();
		stmt.close();
		close();
		return resposta;
	}
}
