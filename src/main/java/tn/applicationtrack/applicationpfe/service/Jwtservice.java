package tn.applicationtrack.applicationpfe.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class Jwtservice {
	private static final String secretKey="5267556B58703273357638792F423F4528472B4B6250655368566D5971337436";
 public String extractUsername(String token) {
	 return extractClaim(token, Claims::getSubject);
 }
 public String genrateToken(UserDetails userDetails) {
	 return generateToken(new HashMap<>(), userDetails);
 }
 public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
	 return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+1000*60*24)).signWith(getSigninKey(),SignatureAlgorithm.HS256).compact();
	 }
 public Boolean IsTokenValid(String token,UserDetails userDetails) {
	 final String username = extractUsername(token);
	 return (username.equals(userDetails.getUsername())) && !IsTokenExpired(token);
 }
 private boolean IsTokenExpired(String token) {
	// TODO Auto-generated method stub
	return extractExpiration(token).before(new Date());
}
private Date extractExpiration(String token) {
	// TODO Auto-generated method stub
	return extractClaim(token, Claims :: getExpiration);
}
public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
	 final Claims claims = extractAllClaims(token);
	 return claimsResolver.apply(claims);
 }
 private Claims extractAllClaims(String token) {
	 return Jwts.parserBuilder().setSigningKey(getSigninKey()).build().parseClaimsJws(token).getBody();
 }
private Key getSigninKey() {
	// TODO Auto-generated method stub
	byte[] keyBytes =Decoders.BASE64.decode(secretKey);
	return Keys.hmacShaKeyFor(keyBytes);
}
}
