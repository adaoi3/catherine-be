package com.goodsoft.catherinebe.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

public final class CustomJwtGrantedAuthoritiesConverter implements
    Converter<Jwt, AbstractAuthenticationToken> {

    private static final String AUTHORITIES_CLAIM_NAME = "roles";

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (String authority : getAuthorities(jwt)) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority));
        }
        return new CustomJwtAuthenticationToken(jwt, grantedAuthorities);
    }

    @SuppressWarnings("unchecked")
    private Collection<String> getAuthorities(Jwt jwt) {
        Object authorities = jwt.getClaim(AUTHORITIES_CLAIM_NAME);
        if (authorities instanceof Collection) {
            return (Collection<String>) authorities;
        }
        return Collections.emptyList();
    }

}
