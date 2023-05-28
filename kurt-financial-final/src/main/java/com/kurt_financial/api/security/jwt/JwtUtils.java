package com.kurt_financial.api.security.jwt;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.kurt_financial.api.security.services.UserDetailsImpl;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import io.jsonwebtoken.*;

@Component
public class JwtUtils {
  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

  @Value("${kurt.app.jwtSecret}")
  private String jwtSecret;

  @Value("${kurt.app.jwtExpirationMs}")
  private int jwtExpirationMs;

  @Value("${kurt.app.jwtCookieName}")
  private String jwtCookie;

  public String getJwtFromRequestBody(RequestWrapper cachedRequest) {
    try {
      String requestBody = cachedRequest.getRequestBody();
      JSONObject jsonObject = new JSONObject(requestBody);
      if (jsonObject.has("sessionID")) {
        System.out.println("Session ID: " + jsonObject.getString("sessionID"));
        return jsonObject.getString("sessionID");
      } else {
        System.out.println("Session ID not found");
        return null;
      }


    } catch (Exception e) {
      // Trate qualquer exceção que possa ocorrer ao processar o corpo da solicitação
      e.printStackTrace();
      return null;
    }
  }

  public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
    String jwt = generateTokenFromUsername(userPrincipal.getUsername());
    ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/").maxAge(24 * 60 * 60).httpOnly(false).build();
    return cookie;
  }

  public ResponseCookie getCleanJwtCookie() {
    ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/").build();
    return cookie;
  }

  public String getUserNameFromJwtToken(String token) {
    System.out.println(Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject());
    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
      return true;
    } catch (SignatureException e) {
      logger.error("Invalid JWT signature: {}", e.getMessage());
    } catch (MalformedJwtException e) {
      logger.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      logger.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      logger.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      logger.error("JWT claims string is empty: {}", e.getMessage());
    }
    System.out.println("JWT token is invalid");
    return false;
  }

  public String generateTokenFromUsername(String username) {
    System.out.println("Generating JWT token for username: " + username);
    return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact();
  }
}
