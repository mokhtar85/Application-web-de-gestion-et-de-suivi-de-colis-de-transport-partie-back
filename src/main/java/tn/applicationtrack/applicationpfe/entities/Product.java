package tn.applicationtrack.applicationpfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id_product;
	Boolean isFragil;
	String name;
	String type;
	String quantity;
	 @ManyToOne
	    @JoinColumn(name = "idCmd")
	 @JsonBackReference
	    private Colis colis;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(Boolean isFragil, String name, String type, String quantity) {
		super();
		this.isFragil = isFragil;
		this.name = name;
		this.type = type;
		this.quantity = quantity;
	}
	public Boolean getIsFragil() {
		return isFragil;
	}
	public void setIsFragil(Boolean isFragil) {
		this.isFragil = isFragil;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public Client getClient() {
		 if (colis != null) {
	            return colis.getClient();
	        }
	        return null;
	}
	public Colis getColis() {
		return colis;
	}
	public void setColis(Colis colis) {
		this.colis = colis;
	}
	
}
