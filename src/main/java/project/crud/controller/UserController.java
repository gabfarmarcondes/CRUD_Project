package project.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import project.crud.services.UserServices;

@RestController
public class UserController {

    @Autowired
    private UserServices userServices;
}
