package project.crud.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.crud.model.User;
import project.crud.services.UserServices;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllerCRUD {

    @Autowired
    private UserServices userServices;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/findAll")
    public ResponseEntity <List<User>> getAllUsers() {return userServices.getAllUsers();}

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userServices.getUserById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return userServices.createUser(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user, @PathVariable Long id) {return userServices.updateUser(id, user);}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        return userServices.deleteUser(id);
    }
}
