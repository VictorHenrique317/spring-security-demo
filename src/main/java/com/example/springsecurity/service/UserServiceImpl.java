package com.example.springsecurity.service;

import com.example.springsecurity.domain.UserEntity;
import com.example.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity foundUserEntity = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("Username " + username + " not found"));

        return new User(foundUserEntity.getUsername(),
                        foundUserEntity.getPassword(),
                        foundUserEntity.getRole().getAuthorities());
    }
}
