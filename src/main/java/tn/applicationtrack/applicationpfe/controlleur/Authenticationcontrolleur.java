package tn.applicationtrack.applicationpfe.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tn.applicationtrack.applicationpfe.entities.Admin;
import tn.applicationtrack.applicationpfe.entities.Client;
import tn.applicationtrack.applicationpfe.requests.AuthenticationRequest;
import tn.applicationtrack.applicationpfe.requests.RegisterRequest;
import tn.applicationtrack.applicationpfe.response.AuthenticationResponse;
import tn.applicationtrack.applicationpfe.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class Authenticationcontrolleur {
	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
		return ResponseEntity.ok(authenticationService.register(request));
	}
	/*@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
		return ResponseEntity.ok(authenticationService.authenticate(request));
	}*/
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody(required = false) Client client) {
	     
	        AuthenticationRequest request = new AuthenticationRequest(client.getUsername(), client.getPassword());
	        return ResponseEntity.ok(authenticationService.authenticate(request));
	    
	}
	  @PostMapping("/RegisterAdmin")
	    public ResponseEntity<String> createAdmin() {
		  authenticationService.createAdmin("admin@example.com", "admin", "password");
	        return ResponseEntity.ok("Admin created successfully");
	    }
}
