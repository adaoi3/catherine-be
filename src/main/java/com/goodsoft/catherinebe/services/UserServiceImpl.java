package com.goodsoft.catherinebe.services;

import com.goodsoft.catherinebe.dao.UserDao;
import com.goodsoft.catherinebe.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDao userDao;

    @Override
    public User getByLogin(String login) {
        return userDao.readByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getByLogin(username);
    }
}
