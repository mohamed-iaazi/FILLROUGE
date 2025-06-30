package com.medo.backend.auth.security;


import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
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





    //getusernamefromtoken

    public String getUsernameFromToken(String token) {
        return null;
    }


    //validite token

    public  boolean validateJwtToken(String token) {
        return true;
    }


    //claims next

}
