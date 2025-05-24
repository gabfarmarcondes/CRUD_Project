package project.crud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import project.crud.model.Phone;

public record UserDTO(
  Long id,

  @NotBlank(message = "User's username can not be blank")
  String username,

  @NotBlank(message = "User's first name can not be blank")
  String firstName,

  @NotBlank(message = "User's last name can not be blank")
  String lastName,

  @Email(message = "Invalid E-mail")
  @NotBlank(message = "User's e-mail can not be blank")
  String email,

  @NotBlank(message = "User's password can not be blank")
  String password,

  @CPF(message = "Invalid CPF")
  @NotBlank(message = "User's CPF can not be blank")
  String cpf,

  Phone phoneNumber
)
{ }
