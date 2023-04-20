package tn.applicationtrack.applicationpfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transporteur")
public class Transporteur  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;
	private String firstName;
	private String lastName;
	private String phone;
	private String city;
	private String adress;
	private String password;
	private String email;
	private String nImmatricualtion;
	private String cin;
	private String confirmPassword;
	
	public Transporteur(Long id_user, String firstName, String lastName, String phone, String city, String adress,
			String password,String email,String nImmatricualtion,String cin, String confirmPassword ) {
		super();
		this.id_user = id_user;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.city = city;
		this.adress = adress;
		this.password = password;
		this.email = email;
		this.nImmatricualtion=nImmatricualtion;
		this.cin=cin;
		this.confirmPassword=confirmPassword;
	}
	
	public Transporteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getnImmatricualtion() {
		return nImmatricualtion;
	}

	public void setnImmatricualtion(String nImmatricualtion) {
		this.nImmatricualtion = nImmatricualtion;
	}

	public String getConfirmpassword() {
		return confirmPassword;
	}

	public void setConfirmpassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}
}
