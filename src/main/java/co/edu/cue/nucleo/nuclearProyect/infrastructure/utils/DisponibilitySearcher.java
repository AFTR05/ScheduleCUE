package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DisponibilitySearcher {
    public static void teacherDisponibility(Course course){

    }


    public static Optional<Integer> dayDisponibility(Student student,String day){
        List<Course> cursosEstudiante =student.getCourse();
        List<Course> cursosEnDiaSeleccionado = cursosEstudiante.stream()
                .filter(curso -> curso.getHourRoom().stream()
                        .anyMatch(hourRoom -> hourRoom.getHourInterval().getDay().equals(day.toString())))
                .collect(Collectors.toList());

        Integer totalHoras = cursosEnDiaSeleccionado.stream()
                .flatMap(curso -> curso.getHourRoom().stream())
                .filter(hourRoom -> hourRoom.getHourInterval().getDay().equals(day.toString()))
                .mapToInt(hourRoom -> hourRoom.getHourInterval().getIntervalEnd().getHour() - hourRoom.getHourInterval().getIntervalBegin().getHour())
                .sum();
        return Optional.of(totalHoras);
    }

    public static Optional<List<RoomHour>> studentDisponibility(HourInterval hourInterval,Student student){
        List<Course> studentCourses =student.getCourse();
        List<Course> daySelectedCourses = studentCourses.stream()
                .filter(curso -> curso.getHourRoom().stream()
                        .anyMatch(hourRoom -> hourRoom.getHourInterval().getDay().equals(hourInterval.getDay().toString())))
                .collect(Collectors.toList());
        List<RoomHour> cc=daySelectedCourses.stream()
                .flatMap(curso -> curso.getHourRoom().stream())
                .filter(hourRoom -> hourRoom.getHourInterval().getDay().equals(hourInterval.getDay().toString())).collect(Collectors.toList());
        List<RoomHour> coursesWithTime =cc.stream().filter(x-> TimeOperator.isIn(hourInterval,x.getHourInterval())).collect(Collectors.toList());
        return Optional.of(coursesWithTime);
    }

}
