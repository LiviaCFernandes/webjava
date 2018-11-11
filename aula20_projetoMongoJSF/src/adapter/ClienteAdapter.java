package adapter;

import org.bson.Document;

import entity.Cliente;

public class ClienteAdapter {

	//conversao para ser gravado
	//conversao para document
	public static Document toDbObject (Cliente c) {
		Document doc = new Document();
			doc.append("_id", c.getId());
			doc.append("nome", c.getNome());
			doc.append("email", c.getEmail());
			doc.append("idade", c.getIdade());
		return doc;
	}
	
	//caminho pra leitura
	public static Cliente getFromObject(Document doc) {
		Cliente c = new Cliente();
			c.setId(doc.getDouble("_id"));
			c.setNome(doc.getString("nome"));
			c.setEmail(doc.getString("email"));
			c.setIdade(doc.getDouble("idade"));
		return c;	
	}
	
}
