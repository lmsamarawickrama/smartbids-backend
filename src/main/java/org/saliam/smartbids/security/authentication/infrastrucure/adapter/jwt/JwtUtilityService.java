package org.saliam.smartbids.security.authentication.infrastrucure.adapter.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.saliam.smartbids.security.authentication.domain.model.UserDetailsImpl;
import org.springframework.security.core.Authentication;

import java.util.Date;

public class JwtUtilityService
{
  private final String jwtSecret;

  private final int jwtExpirationMs;

  public JwtUtilityService(String jwtSecret, int jwtExpirationMs)
  {
    this.jwtSecret = jwtSecret;
    this.jwtExpirationMs = jwtExpirationMs;
  }

  public String generateJwtToken(Authentication authentication)
  {

    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

    return Jwts.builder()
        .setSubject((userPrincipal.getUsername()))
        .setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
        .signWith(SignatureAlgorithm.HS512, jwtSecret)
        .compact();
  }

  public String getUserNameFromJwtToken(String token)
  {
    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateJwtToken(String authToken)
  {
    Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
    return true;
  }
}
