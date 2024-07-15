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
    private String ddi;
    private String ddd;
    private String phoneNumber;


}
