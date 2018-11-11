package persistence;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Medico;
import entity.Paciente;

public class MedicoDao {

	EntityManager manager;
	Query query;

	public MedicoDao() {
		manager = Persistence.createEntityManagerFactory("aula19_projetoJSF").createEntityManager();
	}
	
	public void create(Medico m, Paciente p) throws Exception{
		manager.getTransaction().begin();
			manager.persist(p);
				m.adicionarPaciente(p);
			manager.persist(m);	
		manager.getTransaction().commit();
	}

	public static void main(String[] args) {
		try {
			Paciente p1 = new Paciente (null, "João");
			Medico m1 = new Medico (null,"Roberto","oftalmologista");
			new MedicoDao().create(m1, p1);
			System.out.println("Cadastrado com Sucesso!");
		}catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error: "+ex.getMessage());
		}
	}
	
}
