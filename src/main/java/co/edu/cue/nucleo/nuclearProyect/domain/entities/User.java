package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/**
 * Creación de la clase User para las clases de Teacher, Student y Administrator
 * @author Juan Andrpes Posada
 */
public class User {

    private String name;
    private String email;
    private String password;
}
