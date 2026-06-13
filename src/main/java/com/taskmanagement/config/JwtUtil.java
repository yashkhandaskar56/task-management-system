package com.taskmanagement.config;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	 @Value("${jwt.secret}")
	    private String secret;

	    @Value("${jwt.expiration}")
	    private long expiration;

	    private Key getSigningKey() {
	        return new SecretKeySpec(secret.getBytes(),
	                SignatureAlgorithm.HS256.getJcaName());
	    }

	    public String generateToken(String email) {

	        return Jwts.builder()
	                .setSubject(email)
	                .setIssuedAt(new Date())
	                .setExpiration(
	                        new Date(System.currentTimeMillis() + expiration))
	                .signWith(getSigningKey())
	                .compact();
	    }

	    public String extractUsername(String token) {

	        return Jwts.parserBuilder()
	                .setSigningKey(getSigningKey())
	                .build()
	                .parseClaimsJws(token)
	                .getBody()
	                .getSubject();
	    }

	    public boolean validateToken(String token) {

	        try {
	            Jwts.parserBuilder()
	                    .setSigningKey(getSigningKey())
	                    .build()
	                    .parseClaimsJws(token);

	            return true;

	        } catch (Exception e) {
	            return false;
	        }
	    }

}
