package persistence;

import entity.Funcionario;

public class FuncionarioDao extends Dao {
	
	public void gravar(Funcionario f) throws Exception{
		open();
		stmt = con.prepareStatement("insert into funcionario values (?,?,?)");
		stmt.setInt(1, f.getIdFuncionario());
		stmt.setString(2, f.getNome());
		//gravar data no mysql
		java.sql.Date data = new java.sql.Date(f.getDataAdmissao().getTime());
		stmt.setDate(3, data);
		stmt.execute();
		stmt.close();
		System.out.println("Dados gravados! ");
		close();
	}
}
