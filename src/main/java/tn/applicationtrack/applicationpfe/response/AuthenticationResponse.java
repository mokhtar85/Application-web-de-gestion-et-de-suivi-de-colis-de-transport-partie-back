package tn.applicationtrack.applicationpfe.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.applicationtrack.applicationpfe.entities.Admin;
import tn.applicationtrack.applicationpfe.entities.Client;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
	private String token;
	private Client client;
	private Admin admin ;
}
