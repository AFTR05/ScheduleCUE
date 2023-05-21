package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
public class Duration {
    @Id
    private Integer id;
    private LocalDate begin;
    private LocalDate end;

}
