package com.goal3.kuniokunnonekketsusoccerleague.security;

import com.goal3.kuniokunnonekketsusoccerleague.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return SecurityUser.fromUser(
                this.userRepository
                        .findByLogin(username)
                        .orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found.", username)))
        );
    }
}
