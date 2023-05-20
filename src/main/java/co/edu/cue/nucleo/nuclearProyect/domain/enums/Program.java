package co.edu.cue.nucleo.nuclearProyect.domain.enums;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class Program {
    /*INGSOFT("Ingenieria de software",8,"Ingenieria"),
    INGIND("Ingenieria industrial",8,"Ingenieria")
    ,INGCIV("Ingenieria civil",9,"Ingenieria")
    ,MED("Medicina",12,"Ciencias medicas")
    ,VET("Medicina Veternaria y zootecnia",10,"Ciencias agropecuarias")
    ,ENF("Enfermeria",9,"Ciencias de la salud")
    ,DER("Derecho",8,"Ciencias sociales y juridicas")
    ,PSI("Psicologia",8,"Ciencias humanas y de la educacion")
    ,ADE("Administracion de empresas",7,"Ciencias administrativas")
    ,MDC("Marketing digital y comunicación estratégica",9,"Ciencias administrativas")
    ,TUR("Tecnología en Gestión del Turismo Cultural y de Naturaleza",4,"Ciencias administrativas");*/
    @Id
    @GeneratedValue(strategy    = GenerationType.IDENTITY)
    private String id;
    private String name;
    private Integer countSemester;
    private String faculty;

}
