package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import co.edu.cue.nucleo.nuclearProyect.domain.enums.TypeAdmin;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Administrator extends User{
    @ManyToOne
    private TypeAdmin typeAdmin;
    @Id
    private String id;

}

