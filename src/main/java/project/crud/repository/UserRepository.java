package project.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.crud.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
