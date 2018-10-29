package persistence;

import entity.Usuario;

public class UsuarioDao extends Dao {

	public String filtro (String texto) {
		String resp1 = texto.replaceAll("'", "");
		String resp2 = resp1.replaceAll("<", "");
		String resp3 = resp2.replaceAll("#", "");
		String resp4 = resp3.replaceAll("=", "");
		return resp4;
	}
	
	public void limpar(Usuario u) {
		u.setNome(filtro(u.getNome()));
		u.setEmail(filtro(u.getEmail()));
		u.setPerfil(filtro(u.getPerfil()));
	}
	
	public void create(Usuario u) throws Exception{
		open();
		limpar(u);
		stmt = con.prepareStatement("insert into usuario values (null,?,?,?)");
		stmt.setString(1, u.getNome());
		stmt.setString(2, u.getEmail());
		stmt.setString(3, u.getPerfil());
		stmt.execute();
		stmt.close();
		close();
	}
	
	public static void main(String[] args) {
		try {
			Usuario u = new Usuario(null,"'1'='1'= java","java@gmail.com","usu");
			UsuarioDao dao = new UsuarioDao();
			dao.create(u);
			System.out.println("Dados gravados! ");
		}catch(Exception ex) {
			System.out.println("Error: "+ ex.getMessage());
		}
		String msg = "ola '1'='1'";
		System.out.println(msg.replaceAll("'", ""));
	}
	
}
