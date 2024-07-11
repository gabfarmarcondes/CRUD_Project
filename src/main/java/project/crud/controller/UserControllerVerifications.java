package project.crud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.crud.services.CpfValidationService;
import project.crud.services.VerificationsServices;

@RestController
@RequestMapping("/users/check")
public class UserControllerVerifications {

    @Autowired
    private VerificationsServices verificationsServices;

    @Autowired
    private CpfValidationService cpfValidationService;

    @GetMapping("/id/{id}")
    public ResponseEntity<String> existId(@PathVariable Long id) {
        return verificationsServices.existsUserById(id);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<String> existEmail(@PathVariable String email) {
        return verificationsServices.existsUserByEmail(email);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<String> existUsername(@PathVariable String username) {
        return verificationsServices.existsUserByUsername(username);
    }

    @GetMapping("/cpf/{cpf}")
    public boolean validateCpf(@PathVariable String cpf) {
        return cpfValidationService.validateCpf(cpf);
    }

}
