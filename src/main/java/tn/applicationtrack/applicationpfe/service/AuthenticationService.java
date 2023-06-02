package tn.applicationtrack.applicationpfe.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.applicationtrack.applicationpfe.entities.Admin;
import tn.applicationtrack.applicationpfe.entities.Client;
import tn.applicationtrack.applicationpfe.entities.Typerole;
import tn.applicationtrack.applicationpfe.repository.Adminrepository;
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
	@Autowired
	private Adminrepository adminRepository;

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
	    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	    if (userDetails instanceof Client) {
	        Client client = (Client) userDetails;
	        var jwtToken = jwtService.generateToken(getClientClaims(client), client);
	        return AuthenticationResponse.builder().token(jwtToken).client(client).build();
	    } else if (userDetails instanceof Admin) {
	        Admin admin = (Admin) userDetails;
	        var jwtToken = jwtService.generateToken(getAdminClaims(admin), admin);
	        return AuthenticationResponse.builder().token(jwtToken).admin(admin).build();
	    }

	    throw new UnsupportedOperationException("User type not supported.");
	}

private Map<String, Object> getClientClaims(Client client) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("role", client.getRoleclient().name());
    // Ajouter d'autres claims spécifiques au client si nécessaire
    return claims;
}

private Map<String, Object> getAdminClaims(Admin admin) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("role", admin.getRoleAdmin().name());
    // Ajouter d'autres claims spécifiques à l'admin si nécessaire
    return claims;
}

public void createAdmin(String email, String username, String password) {
    Admin admin = new Admin();
    admin.setEmail(email);
    admin.setUserName(username);
    admin.setPassword(passwordEncoder.encode(password));
    admin.setRoleAdmin(Typerole.ADMIN);;
    
    // Ici, vous pouvez effectuer d'autres opérations ou validations si nécessaire
    
    adminRepository.save(admin);
}


}
