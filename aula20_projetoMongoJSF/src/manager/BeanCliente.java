package manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.Cliente;
import persistence.ClienteDao;

@ManagedBean(name="mb")
@RequestScoped
public class BeanCliente implements Serializable{

	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private List<Cliente> lista;
	
	public BeanCliente() {
		this.cliente = new Cliente();
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> getLista() {
		try {
			if(lista == null) {
				lista = new ArrayList<Cliente>();
			}
			lista = new ClienteDao().findAll();
			return lista;
		}catch (Exception ex) {
			return null;
		}
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}

	public void gravar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			new ClienteDao().save(cliente);
			cliente = new Cliente();
			fc.addMessage(null, new FacesMessage("Dados Gravados!"));
		}catch(Exception ex) {
			fc.addMessage(null, new FacesMessage("Error: "+ex.getMessage()));
		}
	}
	
	public void excluir() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			new ClienteDao().delete(cliente.getId());
			fc.addMessage(null, new FacesMessage("Dado excluido!"));
		}catch (Exception ex) {
			fc.addMessage(null, new FacesMessage("Error: "+ex.getMessage()));
		}
	}
	
	
}
