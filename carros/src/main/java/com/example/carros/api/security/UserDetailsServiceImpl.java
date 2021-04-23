package com.example.carros.api.security;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.User;

import com.example.carros.domain.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.example.carros.domain.User user =  userRep.findByLogin(username);

        if(user == null){
            throw new UsernameNotFoundException("user not found");
        }
        return User.withUsername(username).password(user.getSenha()).roles("USER").build();

    }
}