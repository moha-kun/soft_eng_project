package org.moha.miniproject.services.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface JWTService {

  String generateToken(UserDetails userDetails);

  String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);

  boolean isTokenValid(String token, UserDetails userDetails);

  boolean isTokenExpired(String token);

  Date extractExpiration(String token);

  String extractUsername(String token);

  <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

  Claims extractAllClaims(String token);
}
