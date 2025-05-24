package project.crud.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "admin_table")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ADMIN {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "emailADMIN", unique = true, nullable = false)
    private String emailADMIN;

    @Column(name = "passwordADMIN", nullable = false)
    private String passwordADMIN;

}
