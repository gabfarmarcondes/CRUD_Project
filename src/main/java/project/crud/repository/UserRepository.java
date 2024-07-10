package project.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import project.crud.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByUsername(String username);
    List<User> findAll();
    Optional<User> findById(Long id);

    // Verifications
    User existsUserById(Long id);
    User existsUserByUsername(String username);
    User existsUserByEmail(String email);
}
