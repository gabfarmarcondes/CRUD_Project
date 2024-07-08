package project.crud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.crud.dto.UserDTO;

@Entity
@Table(name = "user_tab")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String firstName;

    @Column(unique = true, nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String password;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @Embedded
    private Phone phoneNumber;

    public User(UserDTO userDTO){
        this.id = userDTO.id();
        this.username = userDTO.username();
        this.firstName = userDTO.firstName();
        this.lastName = userDTO.lastName();
        this.phoneNumber = userDTO.phoneNumber();
        this.email = userDTO.email();
        this.password = userDTO.password();
    }

}
