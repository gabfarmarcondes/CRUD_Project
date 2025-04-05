package project.crud.model;

import jakarta.persistence.Embeddable;

@Embeddable
public record Phone(
        String ddi,
        String ddd,
        String number
)
{ }
