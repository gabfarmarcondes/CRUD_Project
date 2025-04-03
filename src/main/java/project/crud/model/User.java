package project.crud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import project.crud.dto.UserDTO;


@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 20)
    @NotBlank(message = "User's username can not be blank")
    private String username;

    @Column(name = "firstName", nullable = false, length = 50)
    @NotBlank(message = "User's first name can not be blank")
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 50)
    @NotBlank(message = "User's last name can not be blank")
    private String lastName;

    @Email(message = "Invalid E-mail")
    @Column(name = "user_email", unique = true, nullable = false)
    @NotBlank(message = "User's e-mail can not be blank")
    private String email;

    @Column(name = "user_password", nullable = false)
    @NotBlank(message = "User's password can not be blank")
    private String password;

    @CPF(message = "Invalid CPF")
    @Column(name = "user_cpf", unique = true, nullable = false)
    @NotBlank(message = "User's CPF can not be blank")
    private String cpf;

    @Embedded
    @Column(name = "user_phone", unique = true, nullable = false)
    @NotBlank(message = "Users phone can not be blank")
    private Phone phoneNumber;

    public User(UserDTO userDTO){
        this.id = userDTO.id();
        this.username = userDTO.username();
        this.firstName = userDTO.firstName();
        this.lastName = userDTO.lastName();
        this.email = userDTO.email();
        this.password = userDTO.password();
        this.cpf = userDTO.cpf();
        this.phoneNumber = userDTO.phoneNumber();
    }

}
