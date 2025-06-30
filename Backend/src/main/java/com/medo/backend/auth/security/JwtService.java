package com.medo.backend.auth.security;


import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Parser;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.sql.Date;

@Service
public class JwtService {


   @Value("${jwt.secret}")
    private  String jwtSecret;
   @Value("${jwt.expiration}")
    private  String jwtExpiration;
    SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));

    // ganerateKeytoken

    public  String generateJwtToken(String username) {

        long now = System.currentTimeMillis();
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(now))
                .expiration(new Date(now + Integer.parseInt(jwtExpiration)))
                .signWith(key)
                .compact();
    }



    private JwtParser parser(){

        return Jwts.parser().verifyWith(key).build();
    }


    //getusernamefromtoken

    public String getUsernameFromToken(String token) {

        try {

            Claims claims=parser().parseSignedClaims(token).getPayload();
            return claims.getSubject();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //validite token

    public  boolean validateJwtToken(String token, UserDetails userDetails) {

        return token != null && userDetails.getUsername().equals(getUsernameFromToken(getUsernameFromToken(token))) && !isTokenExpired(token);

    }


    public boolean isTokenExpired(String token) {
        try {
            Claims claims = parser().parseSignedClaims(token).getPayload();
            return claims.getExpiration().before(new Date(System.currentTimeMillis()));
        } catch (Exception e) {

        }
            return true; // Assume invalid or expired
        }

    //claims next

}
