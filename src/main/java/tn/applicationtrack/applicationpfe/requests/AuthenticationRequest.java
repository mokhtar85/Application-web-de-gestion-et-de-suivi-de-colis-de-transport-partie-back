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
public class AuthenticationRequest {
private String email;
 String password;
}
