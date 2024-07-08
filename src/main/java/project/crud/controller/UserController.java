package project.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.crud.model.User;
import project.crud.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/findAll")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(getAllUsers());
    }

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody User user) {
        return ResponseEntity.ok(userServices.createUser(user));
    }

}
