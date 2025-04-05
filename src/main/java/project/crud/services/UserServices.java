package project.crud.services;

import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.crud.model.User;
import project.crud.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserServices {

    private final UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<User> getUserById(Long id) {
        Optional<User> users = userRepository.findById(id);
        return users.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional
    public ResponseEntity<User> createUser(User user) {
        try {
            User userSaved = userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } catch (ConstraintViolationException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Transactional
    public ResponseEntity<User> updateUser(Long id, User user) {
        User userUpdate = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userUpdate.setUsername(user.getUsername());
        userUpdate.setPassword(user.getPassword());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setFirstName(user.getFirstName());
        userUpdate.setLastName(user.getLastName());
        userRepository.save(userUpdate);
        return ResponseEntity.ok(userUpdate);
    }

    @Transactional
    public ResponseEntity<User> deleteUser(Long id) {
        User userDelete = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(userDelete);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
