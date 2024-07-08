package project.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.crud.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
}
