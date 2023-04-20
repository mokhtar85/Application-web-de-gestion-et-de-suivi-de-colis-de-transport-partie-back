package tn.applicationtrack.applicationpfe.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "command")
public class Command {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idCmd;
 private String weight;
 private String type;
 private String size;

 private String date;
 private String city;
 private String price;
 public Command(Long idCmd, String weight, String type, String size, String date, String city, String price) {
		super();
		this.idCmd = idCmd;
		this.weight = weight;
		this.type = type;
		this.size = size;
		this.date = date;
		this.city = city;
		this.price = price;
	}
 
	public Command() {
	super();
	// TODO Auto-generated constructor stub
}

	public Long getIdCmd() {
		return idCmd;
	}
	public void setIdCmd(Long idCmd) {
		this.idCmd = idCmd;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
