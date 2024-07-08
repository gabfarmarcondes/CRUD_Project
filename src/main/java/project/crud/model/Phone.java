package project.crud.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Phone {
    private int ddi;
    private int ddd;
    private int number;

}
