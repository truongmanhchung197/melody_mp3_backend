package com.c0720i2.melody.service;

import com.c0720i2.melody.model.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Component
@Service
public class JwtService {
    private static final String SECRET_KEY = "Sons";
    private static final Long EXPIRE_TIME = 100000000L;
    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);

    public String generateAccessToken(Authentication authentication){
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(userPrinciple.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + EXPIRE_TIME*1000))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
    }
    public boolean validateJwtToken(String authToken){
        try{
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(authToken);
            return true;
        }catch (SignatureException e){
            logger.error("Invalid JWT signature -> Message: {} ", e);
        }catch (ExpiredJwtException e){
            logger.error("Expired JWT signature -> Message: {} ", e);
        }catch (MalformedJwtException e){
            logger.error("Invalid JWT token -> Message: {} ", e);
        }catch (UnsupportedJwtException e){
            logger.error("Unsupported JWT -> Message: {} ", e);
        }catch (IllegalArgumentException e){
            logger.error("JWT claims string is empty -> Message: {} ", e);
        }
        return false;
    }
    public String getUserNameFromJwtToken(String token){
        String userName = Jwts.parser().setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody().getSubject();
        return userName;
    }
}
