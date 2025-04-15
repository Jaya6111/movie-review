package com.ex.mreview.security;

import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private static final String SECRET = "fVfMIt9OJQkV6FTFz8xnClK/BzpPkU+vgVE+r9Bz5KmpSki2yxhxIF9KbAx9XxUbnaKkHaZHkFmW+eWDTUG8ng==";
	private static final long VALIDITY = Duration.ofMinutes(15).toMillis();
	
	public String generateToken(String username) {
		
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(Date.from(Instant.now()))
				.setExpiration(Date.from(Instant.now().plusMillis(VALIDITY)))
				.signWith(generateKey())
				.compact();
	}
	
	private SecretKey generateKey() {
		byte[] decodeKey = Base64.getDecoder().decode(SECRET);
		return Keys.hmacShaKeyFor(decodeKey);
	}
	
	public boolean isTokenValid(String jwt) {
		Claims claims = getClaims(jwt);
		return claims.getExpiration().after(Date.from(Instant.now()));
	}
	
	public String extractUsername(String jwt) {
		Claims claims = getClaims(jwt);
		return claims.getSubject();
	}
	
	private Claims getClaims(String jwt) {
		return Jwts.parserBuilder()
				.setSigningKey(generateKey())
				.build()
				.parseClaimsJws(jwt)
				.getBody();
	}
}
