package tn.applicationtrack.applicationpfe.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.applicationtrack.applicationpfe.entities.Client;
import tn.applicationtrack.applicationpfe.entities.Typerole;
import tn.applicationtrack.applicationpfe.repository.Clientrreposiotry;
import tn.applicationtrack.applicationpfe.requests.AuthenticationRequest;
import tn.applicationtrack.applicationpfe.requests.RegisterRequest;
import tn.applicationtrack.applicationpfe.response.AuthenticationResponse;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	private final Clientrreposiotry clientRep;
	private final PasswordEncoder passwordEncoder;
	private final Jwtservice jwtService;
	private final AuthenticationManager authenticationManager;
	public AuthenticationResponse register(RegisterRequest request) {
		 Client client = new Client();
		   client.setFirstName(request.getFirstName());
		   client.setLastName(request.getLastName());
		   client.setAdress(request.getAdress());
		   client.setCity(request.getCity());
		   client.setEmail(request.getEmail());
		   client.setPhone(request.getPhone());
		   client.setUserName(request.getUserName());
		   // Encode the password
	        String encodedPassword = passwordEncoder.encode(request.getPassword());
	        client.setPassword(encodedPassword);
	        String encodedConfirmPassword = passwordEncoder.encode(request.getConfirmPassword());
	        client.setConfirmPassword(encodedConfirmPassword);
	        // Set the role (assuming it's always "client")
	        client.setRoleclient(Typerole.Client);
	        // Save the client entity to the database
	        clientRep.save(client);
	        var jwtToken = jwtService.genrateToken(client);
		return AuthenticationResponse.builder().token(jwtToken).client(client).build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		// TODO Auto-generated method stub
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		var client = clientRep.findByEmail(request.getEmail()).orElseThrow();
		 var jwtToken = jwtService.genrateToken(client);
		return AuthenticationResponse.builder().token(jwtToken).client(client).build();
	}
	

}
