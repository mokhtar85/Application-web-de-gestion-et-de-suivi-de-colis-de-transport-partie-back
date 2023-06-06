package tn.applicationtrack.applicationpfe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;
import tn.applicationtrack.applicationpfe.repository.Adminrepository;
import tn.applicationtrack.applicationpfe.repository.Clientrreposiotry;
import tn.applicationtrack.applicationpfe.repository.Transporteurrepository;
import tn.applicationtrack.applicationpfe.service.AdminServiceImpl;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
	private final Clientrreposiotry clientRepository;
	private final Adminrepository adminRepository;
	private final Transporteurrepository transporteurRepository;
	@Bean
	public 	UserDetailsService  userDetailsService () {
		return new CustomUserDetailsService(clientRepository, adminRepository,transporteurRepository);
		}
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder();
	}
	@Bean
	public AdminServiceImpl adminService() {
	    // Retourner une instance de votre service AdminService
	    return new AdminServiceImpl(adminRepository);
	}
}
