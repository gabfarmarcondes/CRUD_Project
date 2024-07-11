package project.crud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;
import project.crud.model.Phone;

public record UserDTO(
  Long id,

  @NotBlank
  String username,

  @NotBlank
  String firstName,

  @NotBlank
  String lastName,

  @NotBlank
  @UniqueElements
  String email,

  @UniqueElements
  @NotBlank
  String password,

  String cpf,

  @NotNull
  Phone phoneNumber

)
{
}
