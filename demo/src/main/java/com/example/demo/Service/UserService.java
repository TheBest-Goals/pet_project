package com.example.demo.Service;

import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository uRepository;
    private final PasswordEncoder pEncoder;

    public UserService(UserRepository uRepository, PasswordEncoder pEncoder) {
        this.uRepository = uRepository;
        this.pEncoder = pEncoder;
    }

    public User registerUser(User user){

        String encodedPassword = pEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        user.setRole(Role.ROLE_USER); // every sign with basical role "user"

        if(user.getBalance() == null){ // and if balance equal null -> даем начальный счет короче 0.0
            user.setBalance(0.0);
        }

        return uRepository.save(user); // save user data in repository user
    }
}
