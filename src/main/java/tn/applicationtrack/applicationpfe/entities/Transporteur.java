package tn.applicationtrack.applicationpfe.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="transporteur")
public class Transporteur implements UserDetails  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id_user;
	private String firstName;
	private String lastName;
	private String userName;
	private String phone;
	private String city;
	private String adress;
	private String password;
	private String email;
	private String nImmatricualtion;
	private String cin;
	private String confirmPassword;
	private String licenseNumber;
	private String vehicleType;
	@Enumerated(EnumType.STRING)
	private Typerole Roletransporteur;
	 @OneToMany(mappedBy = "transporteur")
	    private List<Notification> notifications;
	
    public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Typerole getRoletransporteur() {
		return Roletransporteur;
	}

	public void setRoletransporteur(Typerole roletransporteur) {
		Roletransporteur = roletransporteur;
	}

	public List<AffectationColis> getAffectations() {
		return affectations;
	}

	public void setAffectations(List<AffectationColis> affectations) {
		this.affectations = affectations;
	}

	@OneToMany(mappedBy = "transporteur")
    private List<AffectationColis> affectations;
	
	
	
	public Transporteur(String firstName, String lastName, String userName, String phone, String city, String adress,
			String password, String email, String nImmatricualtion, String cin, String confirmPassword,
			String licenseNumber, String vehicleType, List<AffectationColis> affectations,Typerole Roletransporteur) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.phone = phone;
		this.city = city;
		this.adress = adress;
		this.password = password;
		this.email = email;
		this.nImmatricualtion = nImmatricualtion;
		this.cin = cin;
		this.confirmPassword = confirmPassword;
		this.licenseNumber = licenseNumber;
		this.vehicleType = vehicleType;
		this.affectations = affectations;
		this.Roletransporteur=Roletransporteur;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority(Roletransporteur.name())) ;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
