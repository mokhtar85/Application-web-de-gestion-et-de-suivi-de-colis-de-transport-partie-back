package tn.applicationtrack.applicationpfe.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestTransporteur {
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
	public String getnImmatricualtion() {
		return nImmatricualtion;
	}
	public void setnImmatricualtion(String nImmatricualtion) {
		this.nImmatricualtion = nImmatricualtion;
	}
	
}
