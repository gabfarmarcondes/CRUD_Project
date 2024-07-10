package project.crud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.crud.services.VerificationsServices;

@RestController
@RequestMapping("/user/verification")
public class UserControllerVerifications {

    @Autowired
    private VerificationsServices verificationsServices;

    @GetMapping("{id}")
    public ResponseEntity<User> existId(@PathVariable Long id) {
        verificationsServices.existsUserById(id);
        return ResponseEntity.ok().build();
    }

}
