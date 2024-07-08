package project.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import project.crud.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByUsername(String username);
    List<User> findAll();
}
