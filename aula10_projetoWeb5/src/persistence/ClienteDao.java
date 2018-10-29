package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Cliente;
import entity.Endereco;

public class ClienteDao {

	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;

	public void create(Cliente c) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
				session.save(c);
			transaction.commit();
		session.close();	
	}
	
	public void create(Cliente c, Endereco e) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
				session.save(c); //gravo principal
					e.setCliente(c); //mais fraco vai buscar o principal
					session.save(e); //gravo auxiliar
			transaction.commit();
		session.close();	
	}
	
	public List<Cliente> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Cliente> lista = session.createQuery("from Cliente").list();
		session.close();
		return lista;
	}
	//se faz o metodo no dao, roda ele no managerbean<-->sistema.xhtml
	public Cliente buscarCodigo(Integer cod) {
		session = HibernateUtil.getSessionFactory().openSession();
		Cliente resp = (Cliente) session.get(Cliente.class, cod);
		session.close();
		return resp;//cheio ou vazio
	}
	
	public static void main(String[] args) {
		Cliente c = new Cliente (null,"beira","m");
		Endereco e = new Endereco (null, "Av Rio Branco, 185", "Centro", "Rio de Janeiro", "RJ", "20040007");
		
		try {
//			new ClienteDao().create(c,e);
//			System.out.println("Dados Gravados!");
//			for(Cliente cli: new ClienteDao().findAll()) {
//				System.out.println(cli);
//				System.out.println(cli.getEndereco());
//			}
			Cliente c1 = new Cliente (null,"lu","f");
			Endereco e1 = new Endereco (null, "Av Rio Branco, 185", "Centro", "Rio de Janeiro", "RJ", "20040007");
				c1.setEndereco(e1);//ao gravar o cliente automaticamente grava o endereco
				new ClienteDao().create(c1,c1.getEndereco());
				System.out.println("Dados do Cliente e Endereco gravados!");
		}catch (Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
	}
}
