package project.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.crud.repository.UserRepository;

import java.util.Optional;

@Service
public class VerificationsServices {

    @Autowired
    private UserRepository userRepository;

    // by id
    public ResponseEntity<String> existsUserById (Long id) {
        Optional<Boolean> user = Optional.of(userRepository.existsUserById(id));
        return user.map(u -> ResponseEntity.ok("User with this ID already exists"))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found"));
    }

    // by username
    public ResponseEntity<String> existsUserByUsername (String username) {
        Optional<Boolean> user = Optional.of(userRepository.existsUserByUsername(username));
        return user.map(u -> ResponseEntity.ok("User with this username already exists"))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found"));
    }

    // by email
    public ResponseEntity<String> existsUserByEmail (String email) {
        Optional<Boolean> user = Optional.of(userRepository.existsUserByEmail(email));
        return user.map(u -> ResponseEntity.ok("User with this e-mail already exists"))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found"));
    }
}
