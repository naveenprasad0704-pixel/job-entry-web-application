package project3.example.project3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project3.example.project3.model.User;
import project3.example.project3.repository.UserRepository;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public boolean authenticate(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        return userOpt.map(user -> user.getPassword().equals(password)).orElse(false);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}