package project.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.crud.model.User;
import project.crud.repository.UserRepository;

import java.util.List;


@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    //GET
    public void getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            ResponseEntity.noContent().build();
        } else {
            ResponseEntity.ok(users);
        }
    }
    //POST
    public ResponseEntity<User> createUser(User user) {
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }
    //PUT
    //DELETE
    }
