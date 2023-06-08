package co.edu.cue.nucleo.nuclearProyect.mapping.dtos;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.ProgramSemester;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record StudentRequestDTO(        @JsonProperty("id") String id,
                                        @JsonProperty("name") String name,
                                        @JsonProperty("active") Boolean active,
                                        @JsonProperty("email") String email,
                                        @JsonProperty("password") String password,
                                        @JsonProperty("course") List<Course> course,
                                        @JsonProperty("ownSemester") ProgramSemester ownSemester){

}
