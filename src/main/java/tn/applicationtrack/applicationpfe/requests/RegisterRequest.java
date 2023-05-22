package tn.applicationtrack.applicationpfe.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.applicationtrack.applicationpfe.response.AuthenticationResponse;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	private String userName;
	private String firstName;
	private String lastName;
	private String phone;
	private String city;
	private String adress;
	private String password;
	private String confirmPassword;
	private String email;
}
