package co.edu.cue.nucleo.nuclearProyect.mapping.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginRequestDTO(@JsonProperty("id")
                              String id, @JsonProperty("password")
                                            String password) {
}
