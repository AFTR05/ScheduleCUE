package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.TypeAdmin;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
public class Administrator extends User{
    private String name;
    @JoinColumn(name = "email_address")
    @Column(name = "email_address")
    private String email;
    private String password;
    @ManyToOne
    private TypeAdmin typeAdmin;
    @Id
    private String id;

}

