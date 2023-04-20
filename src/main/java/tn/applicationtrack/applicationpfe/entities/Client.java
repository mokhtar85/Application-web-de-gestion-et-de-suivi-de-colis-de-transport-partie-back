package tn.applicationtrack.applicationpfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="client")
public class Client  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;
	private String userName;
	private String firstName;
	private String lastName;
	private String phone;
	private String city;
	private String adress;
	private String password;
	private String confirmPassword;
	private String email;
	
	@ManyToOne
	private Role Roleclient;
	
}
