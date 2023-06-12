package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.HourInterval;

import java.time.LocalTime;
import java.util.Optional;

public interface HourIntervalDao{
    Optional<HourInterval> byProps(String day, LocalTime begin, LocalTime end);

    void createWithNoID(String day, String begin, String end);
}
