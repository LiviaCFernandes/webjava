package persistence;

import entity.Usuario;

public class UsuarioDaoFraco extends Dao {
	
	public void create(Usuario u) throws Exception{
		open();
		stmt = con.prepareStatement("insert into usuario(nome) values ('"+u.getNome()+ "')");
		
		stmt.execute();
	stmt.close();
	close();
	}
	
	public Usuario logar(Usuario u) throws Exception{
		open();
		stmt = con.prepareStatement("select * from usuario where email='" + u.getEmail() + "'and nome='" + u.getNome() + "'");
		rs = stmt.executeQuery();
		Usuario usu = null;
		if(rs.next()) {
			usu = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}
	stmt.close();
	close();
	return usu;
	}
	
	public static void main(String[] args) {
		UsuarioDaoFraco dao = new UsuarioDaoFraco();
		try {
			Usuario u = new Usuario (null, "demitido", null, null);
			dao.create(u);
			System.out.println("Dados gravados! "+ u);
			Usuario x = new Usuario (null,null,null,null);
			x.setNome("Cast('10; drop table usuario' as varchar(30))"); 
			dao.create(x);
			System.out.println("Tabela gerada!" + x);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
