package com.goodsoft.catherinebe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class Role implements GrantedAuthority {

    private Long id;
    private String name;

    @Override
    @JsonIgnore
    public String getAuthority() {return "ROLE_" + name;}
}
