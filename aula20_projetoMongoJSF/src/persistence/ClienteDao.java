package persistence;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import adapter.ClienteAdapter;
import entity.Cliente;

public class ClienteDao extends Dao {

	public void save(Cliente c) throws Exception {
		try {
			// classe para documento e depois ele grava
			MongoCollection<Document> coll = getDB().getCollection("cliente");
			coll.insertOne(ClienteAdapter.toDbObject(c));
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close();
		}
	}

	public void edit(Cliente c) throws Exception {
		try {
			// classe para documento e depois ele grava
			MongoCollection<Document> coll = getDB().getCollection("cliente");
			coll.updateOne(eq("_id", c.getId()), new Document("$set", ClienteAdapter.toDbObject(c)));
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close();
		}
	}

	public List<Cliente> findAll() throws Exception {
		MongoCursor<Document> doc = null;
		List<Cliente> lista = new ArrayList<>();
		try {
			MongoCollection<Document> coll = getDB().getCollection("cliente");
			doc = coll.find().iterator();
			while (doc.hasNext()) {
				lista.add(ClienteAdapter.getFromObject(doc.next()));
			}
			return lista;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			doc.close();
			close();
		}
		return null;
	}

	public Cliente findById(Double id) throws Exception {
		Cliente cliente = null;
		MongoCollection<Document> coll = getDB().getCollection("cliente");
		MongoCursor<Document> c = coll.find(eq("_id", id)).iterator();
		while (c.hasNext()) {
			cliente = ClienteAdapter.getFromObject(c.next());
		}
		return cliente;
	}
	
	public void delete(Double id) throws Exception {
		MongoCollection<Document> coll = getDB().getCollection("cliente");
		coll.findOneAndDelete(eq("_id",id));
	}
	
	
	public static void main(String[] args) {
		try {
			Cliente c = new ClienteDao().findById(103.);
			System.out.println("Cliente: "+c);
		}catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
	}
	
}
