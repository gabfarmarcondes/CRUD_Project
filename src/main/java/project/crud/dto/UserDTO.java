package project.crud.dto;

import project.crud.model.Phone;

public record UserDTO(
  Long id,
  String username,
  String firstName,
  String lastName,
  String email,
  String password,
  String cpf,
  Phone phoneNumber
)
{ }
