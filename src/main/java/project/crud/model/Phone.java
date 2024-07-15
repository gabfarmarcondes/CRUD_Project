package project.crud.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Phone {
    private int ddi;
    private int ddd;
    private String phoneNumber;


}
