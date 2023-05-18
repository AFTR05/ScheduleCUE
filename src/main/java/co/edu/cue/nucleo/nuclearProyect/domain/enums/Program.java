package co.edu.cue.nucleo.nuclearProyect.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Program { INGSOFT("Ingenieria de software",8,"Ingenieria"),
    INGIND("Ingenieria industrial",8,"Ingenieria")
    ,INGCIV("Ingenieria civil",9,"Ingenieria")
    ,MED("Medicina",12,"Ciencias medicas")
    ,VET("Medicina Veternaria y zootecnia",10,"Ciencias agropecuarias")
    ,ENF("Enfermeria",9,"Ciencias de la salud")
    ,DER("Derecho",8,"Ciencias sociales y juridicas")
    ,PSI("Psicologia",8,"Ciencias humanas y de la educacion")
    ,ADE("Administracion de empresas",7,"Ciencias administrativas")
    ,MDC("Marketing digital y comunicación estratégica",9,"Ciencias administrativas")
    ,TUR("Tecnología en Gestión del Turismo Cultural y de Naturaleza",4,"Ciencias administrativas");
    private String name;
    private Integer countSemester;
    private String faculty;

}
