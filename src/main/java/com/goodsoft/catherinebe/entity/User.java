package com.goodsoft.catherinebe.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public class User implements UserDetails {

    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private List<Role> roles;
    private LocalDate birthDate;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String login, String password,
        String email, List<Role> roles, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.birthDate = birthDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
