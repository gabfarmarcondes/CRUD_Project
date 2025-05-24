package project.crud.services;

import jakarta.validation.ConstraintViolationException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.crud.config.ResponseWrapper;
import project.crud.dto.UserDTO;
import project.crud.model.User;
import project.crud.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserServices {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServices(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(users, HttpStatus.OK);
    }

    public ResponseEntity<User> getUserById(Long id) {
        Optional<User> users = userRepository.findById(id);
        return users.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<ResponseWrapper<UserDTO>> createUser(UserDTO userDTO) {
        try {
            User userSaved = modelMapper.map(userDTO, User.class);
            userRepository.save(userSaved);
            UserDTO newUserDTO = modelMapper.map(userSaved, UserDTO.class);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseWrapper<>("User created", newUserDTO));
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ResponseWrapper<>("CPF or E-mail already created", null));
        } catch (ConstraintViolationException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest()
                    .body(new ResponseWrapper<>("Invalid data", null));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>("Internal Server ERROR", null));
        }
    }

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

    public ResponseEntity<User> deleteUser(Long id) {
        User userDelete = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(userDelete);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
