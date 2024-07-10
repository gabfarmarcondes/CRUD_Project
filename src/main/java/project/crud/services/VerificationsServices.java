package project.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.crud.model.User;
import project.crud.repository.UserRepository;

import java.util.Optional;

@Service
public class VerificationsServices {

    @Autowired
    private UserRepository userRepository;

    // by id
    public ResponseEntity<User> existsUserById (Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // by username
    // by email
}
