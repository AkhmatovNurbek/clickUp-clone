package uz.clickup.clickupclone.security;

import io.jsonwebtoken.Jwts;
import org.springframework.security.config.annotation.rsocket.RSocketSecurity;

public class JwtProvider {
    public String generateToken(String username){
        String token = Jwts
                .builder()
                .
    }
}
