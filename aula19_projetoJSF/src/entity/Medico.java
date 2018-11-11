package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="medico")
public class Medico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMedico;
	@Column
	private String nomeMedico;
	@Column
	private String especializacao;

	//cria uma tabela relacional
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable (name="medicopaciente",
                joinColumns=@JoinColumn(name="id_medico"), 
	             inverseJoinColumns=@JoinColumn(name="id_paciente"))
	private List<Paciente> pacientes;
	
	
	public Medico() {
	}
	
	public Medico(Integer idMedico, String nomeMedico, String especializacao) {
		this.idMedico = idMedico;
		this.nomeMedico = nomeMedico;
		this.especializacao = especializacao;
	}
		
	@Override
	public String toString() {
		return "Medico [idMedico=" + idMedico + ", nomeMedico=" + nomeMedico + ", especializacao=" + especializacao
				+ "]";
	}

	public Integer getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}
	public String getNomeMedico() {
		return nomeMedico;
	}
	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}
	public String getEspecializacao() {
		return especializacao;
	}
	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	//medico adiciona paciente
	public void adicionarPaciente(Paciente p) {
		if(pacientes==null) {
			pacientes = new ArrayList<Paciente>();
		}
		pacientes.add(p);
	}
	
}
