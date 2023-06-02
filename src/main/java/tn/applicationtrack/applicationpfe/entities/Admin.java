package tn.applicationtrack.applicationpfe.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



@Entity
@Table(name="admin")
public class Admin implements UserDetails   {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_admin;
	private String password;
	private String email;
	private String userName;
	@Enumerated(EnumType.STRING)
	private Typerole roleAdmin;
	public Admin(String password, String email, String userName, Typerole roleAdmin) {
		super();
		this.password = password;
		this.email = email;
		this.userName = userName;
		this.roleAdmin = roleAdmin;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Typerole getRoleAdmin() {
		return roleAdmin;
	}
	public void setRoleAdmin(Typerole roleAdmin) {
		this.roleAdmin = roleAdmin;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority(roleAdmin.name()));
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
