package tn.applicationtrack.applicationpfe.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;

@Entity
@Table(name="affectation_colis")
public class AffectationColis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long affectation_id;
	@JsonIgnore
	@ManyToOne
	private Admin admin;
	@JsonIgnore
	@ManyToOne
	private Transporteur transporteur;

	@OneToMany
	 @JsonManagedReference
	 @JoinTable(
			    name = "affectation_colis_colis", // Nom de la table de jointure
			    joinColumns = @JoinColumn(name = "affectation_id"), // Colonne de jointure de cette entité
			    inverseJoinColumns = @JoinColumn(name = "idCmd") // Colonne de jointure de l'entité Colis
			) // Spécifie la colonne de jointure
	private List<Colis> colisList;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAffectation;
	public AffectationColis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AffectationColis(Transporteur transporteur, List<Colis> colisList, Date dateAffectation) {
		super();
	
		this.transporteur = transporteur;
		this.colisList = colisList;
		this.dateAffectation = dateAffectation;	
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Transporteur getTransporteur() {
		return transporteur;
	}
	public void setTransporteur(Transporteur transporteur) {
		this.transporteur = transporteur;
	}
	public List<Colis> getColisList() {
		return colisList;
	}
	public void setColisList(List<Colis> colisList) {
		this.colisList = colisList;
	}
	public Date getDateAffectation() {
		return dateAffectation;
	}
	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}
	

}
