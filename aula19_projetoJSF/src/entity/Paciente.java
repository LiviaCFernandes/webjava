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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="paciente")
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPaciente;
	
	@Column(length=50)
	private String nome;
		
	@ManyToMany(mappedBy="pacientes", fetch=FetchType.EAGER)
	private List<Medico> medicos;
	
	
	public Paciente() {
	}
	
	public Paciente(Integer idPaciente, String nome) {
		this.idPaciente = idPaciente;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Paciente [idPaciente=" + idPaciente + ", nome=" + nome + "]";
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Medico> getMedicos() {
		return medicos;
	}
	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}
	
	public void adicionarMedico(Medico m) {
		if(medicos==null) {
			medicos = new ArrayList<Medico>();
		}
		medicos.add(m);
	}
	
}
