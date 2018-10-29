package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

	Connection con;//conexao com banco
	PreparedStatement stmt; //conexao com a tabela
	ResultSet rs; //resultado da tabela
	
	public void open() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web1", "root", "coti");
	}
	
	public void close() throws Exception{
		con.close();
	}
}
