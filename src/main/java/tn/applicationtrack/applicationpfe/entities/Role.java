package tn.applicationtrack.applicationpfe.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRole ;
	@Enumerated(EnumType.STRING)
	private Typerole type;
	

	@OneToMany(mappedBy = "Roleclient")
	private List<Client> listClient = new ArrayList<>();
	public Role(Long idRole, Typerole type) {
		super();
		this.idRole = idRole;
		this.type = type;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public Typerole getType() {
		return type;
	}
	public void setType(Typerole type) {
		this.type = type;
	}
	
	
	
}
