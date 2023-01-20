package com.goodsoft.catherinebe.services;

import com.goodsoft.catherinebe.entity.User;

public interface UserService {

    User getByLogin(String login);

}
