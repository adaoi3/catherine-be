package com.goodsoft.catherinebe.config;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class CustomJwtAuthenticationToken extends JwtAuthenticationToken {

    public CustomJwtAuthenticationToken(Jwt jwt,
        Collection<? extends GrantedAuthority> authorities) {
        super(jwt, authorities);
    }

    public Long getId() {
        return this.getToken().getClaim("id");
    }

}
