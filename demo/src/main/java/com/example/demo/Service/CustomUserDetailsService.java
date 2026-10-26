package com.example.demo.Service;


import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository uRepository;

    public CustomUserDetailsService(UserRepository uRepository){
        this.uRepository = uRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = uRepository.findByUsername(username) // find by usernames
                .orElseThrow(() -> new UsernameNotFoundException("user was not found")); // and call new usernamentfndexc if user was not found

        return new org.springframework.security.core.userdetails.User( // AND I FINALLY DONT UNSERSTAND THIS ROW MANNNN
                user.getUsername(), // login
                user.getPassword(), // hash password
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name())) // AND THIS TOOOOOO
                /// user.getRole().name from enum to STRING
                 ///new SimpleGrantedAuthority it's translate for system for understand "ROLE"
                 ///Collections.singletonList create single Lists
        );
    }
}
