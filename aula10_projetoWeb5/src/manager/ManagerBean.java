package manager;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.Cliente;
import entity.Endereco;
import persistence.ClienteDao;

//jsf passado era framework
//jsf hoje é especificado pela oracle

@ManagedBean(name="mb")
@RequestScoped
public class ManagerBean {
	
	private Cliente cliente;
	private Endereco endereco;
	private List<Cliente> clientes;
	private Integer MBcodigo=0;

	//inicializa os dois 	
	public ManagerBean() {
		this.cliente = new Cliente();
		this.endereco = new Endereco();
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Integer getMBcodigo() {
		return MBcodigo;
	}
	public void setMBcodigo(Integer mBcodigo) {
		MBcodigo = mBcodigo;
	}

	public void gravar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			//validar
			new ClienteDao().create(cliente, endereco);
			//limpar
			cliente = new Cliente();
			endereco = new Endereco();
			fc.addMessage(null, new FacesMessage("Dados Gravados!"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//vai chamar os clientes preenchidos
	public List<Cliente> getClientes(){
		this.clientes = new ClienteDao().findAll();
		return clientes;
	}
	
	public void buscarCodigo() {
		FacesContext fc = FacesContext.getCurrentInstance();
		this.cliente = new ClienteDao().buscarCodigo(MBcodigo);
		if(this.cliente==null) {
			fc.addMessage(null, new FacesMessage("Nao Encontrado!"));
		}else {
			fc.addMessage(null, new FacesMessage("Encontrado: "+this.cliente));
		}
	}
	
}
