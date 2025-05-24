package project.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.crud.model.ADMIN;

@Repository
public interface ADMINRepository extends JpaRepository<ADMIN, String> { }
