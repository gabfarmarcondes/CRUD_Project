package project.crud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import project.crud.dto.UserDTO;


@Entity(name = "user")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
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
