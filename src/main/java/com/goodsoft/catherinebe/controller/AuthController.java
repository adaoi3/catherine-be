package com.goodsoft.catherinebe.controller;

import com.goodsoft.catherinebe.dto.AuthenticationDto;
import com.goodsoft.catherinebe.dto.TokenDto;
import com.goodsoft.catherinebe.entity.User;
import com.goodsoft.catherinebe.services.TokenServiceImpl;
import com.goodsoft.catherinebe.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class AuthController {

    private final TokenServiceImpl tokenServiceImpl;
    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/token")
    public ResponseEntity<TokenDto> token(@RequestBody AuthenticationDto authenticationDto) {
        User user = (User) userService.loadUserByUsername(authenticationDto.getLogin());
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (!passwordEncoder.matches(authenticationDto.getPassword(), user.getPassword())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        log.debug("Token requested for user: '{}'", user.getLogin());
        String token = tokenServiceImpl.generateToken(user);
        log.debug("Token granted: {}", token);
        return ResponseEntity.ok(new TokenDto(token));
    }

}
