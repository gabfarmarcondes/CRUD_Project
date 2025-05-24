package project.crud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ADMINDTO(
        String id,

        @Email(message = "Invalid E-mail")
        @NotBlank(message = "ADMIN's e-mail can not be blank")
        String emailADMIN,


        @NotBlank(message = "User's password can not be blank")
        String passwordADMIN
)
{ }
