package tn.applicationtrack.applicationpfe.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "colis")
public class Colis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idCmd;
 private String adresseExpedition;
 private String adresseLivraison;
 private String taille;
 private String poid;
 @DateTimeFormat(pattern = "yyyy-MM-dd")
 private LocalDate date;
 private Long numberProduct;
 private String remarques;
 @OneToMany(mappedBy = "colis", cascade = CascadeType.ALL)
 @JsonManagedReference
 private List<Product> produits;
 @ManyToOne
 @JoinColumn(name = "id_user")
 private Client client;

public Colis() {
	super();
	// TODO Auto-generated constructor stub
}
public Colis(String adresseExpedition, String adresseLivraison, String taille, String poid, LocalDate date,
		Long numberProduct, String remarques) {
	super();
	this.adresseExpedition = adresseExpedition;
	this.adresseLivraison = adresseLivraison;
	this.taille = taille;
	this.poid = poid;
	this.date = date;
	this.numberProduct = numberProduct;
	this.remarques = remarques;
}
public Long getIdCmd() {
	return idCmd;
}
public void setIdCmd(Long idCmd) {
	this.idCmd = idCmd;
}
public String getAdresseExpedition() {
	return adresseExpedition;
}
public void setAdresseExpedition(String adresseExpedition) {
	this.adresseExpedition = adresseExpedition;
}
public String getAdresseLivraison() {
	return adresseLivraison;
}
public void setAdresseLivraison(String adresseLivraison) {
	this.adresseLivraison = adresseLivraison;
}
public String getTaille() {
	return taille;
}
public void setTaille(String taille) {
	this.taille = taille;
}
public String getPoid() {
	return poid;
}
public void setPoid(String poid) {
	this.poid = poid;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public Long getNumberProduct() {
	return numberProduct;
}
public void setNumberProduct(Long numberProduct) {
	this.numberProduct = numberProduct;
}
public String getRemarques() {
	return remarques;
}
public void setRemarques(String remarques) {
	this.remarques = remarques;
}
public List<Product> getProduits() {
	return produits;
}
public void setProduits(List<Product> produits) {
	this.produits = produits;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}

public void addProduct(Product product) {
    produits.add(product);
    product.setColis(this);
}
}