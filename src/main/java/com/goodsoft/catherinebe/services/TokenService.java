package com.goodsoft.catherinebe.services;

import com.goodsoft.catherinebe.entity.User;

public interface TokenService {

    String generateToken(User user);

}
