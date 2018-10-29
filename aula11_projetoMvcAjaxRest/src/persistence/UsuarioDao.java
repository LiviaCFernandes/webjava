package persistence;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import dto.DtoUsuarioEndereco;
import entity.Endereco;
import entity.Usuario;

public class UsuarioDao extends Dao {

	public void create(Usuario u, Endereco e) throws Exception {
		open();
		con.setAutoCommit(false);
		stmt = con.prepareStatement("insert into usuario values (null,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getEmail());
			stmt.execute();
		rs = stmt.getGeneratedKeys();
		rs.next();
		int chave = rs.getInt(1);
		stmt.close();

		stmt = con.prepareStatement("insert into endereco values (null,?,?,?,?,?,?)");
			stmt.setString(1, e.getLogradouro());
			stmt.setString(2, e.getBairro());
			stmt.setString(3, e.getCidade());
			stmt.setString(4, e.getEstado());
			stmt.setString(5, e.getCep());
			stmt.setInt(6, chave);
			stmt.execute();
			stmt.close();
		con.setAutoCommit(true);
		close();
	}
	
	public List<DtoUsuarioEndereco> findAllDTO() throws Exception{
		open();
		stmt = con.prepareStatement("select * from V$UsuarioEndereco");
		rs = stmt.executeQuery();
		List<DtoUsuarioEndereco> lista = new ArrayList<DtoUsuarioEndereco>();
		while (rs.next()){
			Usuario u = new Usuario (rs.getInt(1), rs.getString(2), rs.getString(3));
			Endereco e = new Endereco (rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8), rs.getString(9));
					e.setUsuario(u);
			DtoUsuarioEndereco dto = new DtoUsuarioEndereco(u,e);
			lista.add(dto);
		}
		close();
		return lista;
	}
	
	public static void main(String[] args) {
		try {
//			Usuario u = new Usuario (null, "gustavo", "gu@gmail.com");
//			Endereco e = new Endereco (null, "Av Rio Branco, 185", "centro", "Rio de Janeiro", "RJ", "20040007");
//			new UsuarioDao().create(u, e);
//			System.out.println("Dados Gravados!");
			System.out.println(new UsuarioDao().findAllDTO());
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
