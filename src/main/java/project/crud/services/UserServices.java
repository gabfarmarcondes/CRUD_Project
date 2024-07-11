package project.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import project.crud.model.User;
import project.crud.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CpfValidationService cpfValidationService;

    //GET
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
             return ResponseEntity.ok(users);
        }
    }

    public ResponseEntity<User> getUserById(Long id) {
        Optional<User> users = userRepository.findById(id);
        return users.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }
    //POST
    public ResponseEntity<User> createUser(@RequestBody User user) {

        if(!cpfValidationService.validateCpf(user.getCpf())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        }

        try {
            User userSaved = userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    //PUT
    public ResponseEntity<User> updateUser(@PathVariable Long id, User user) {
        User userUpdate = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userUpdate.setUsername(user.getUsername());
        userUpdate.setPassword(user.getPassword());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setFirstName(user.getFirstName());
        userUpdate.setLastName(user.getLastName());
        userRepository.save(userUpdate);
        return ResponseEntity.ok(userUpdate);
    }
    //DELETE
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        User userDelete = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(userDelete);
        return ResponseEntity.ok(userDelete);
    }
}
