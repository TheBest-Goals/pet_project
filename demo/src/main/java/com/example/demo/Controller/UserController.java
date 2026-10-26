package com.example.demo.Controller;

import com.example.demo.Service.UserService;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserRepository uRepository;
    private final UserService uService;

    public UserController(UserRepository uRepository, UserService uService) {
        this.uRepository = uRepository;
        this.uService = uService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return uRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User lRequest) {
        Optional<User> userOpt = uRepository.findByEmail(lRequest.getEmail());

        if (userOpt.isPresent() && userOpt.get().getPassword().equals(lRequest.getPassword())) {
            return ResponseEntity.ok(userOpt.get());
        }

        return ResponseEntity.status(401).body("неверный логин или пароль");
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User saveUser = uService.registerUser(user);
        return ResponseEntity.ok(saveUser);
    }

}
