package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DisponibilitySearcher {
    public static List<Course> filterbyDay(Student student,String day){
        return student.getCourse().stream()
                .filter(curso -> curso.getHourRoom().stream()
                        .anyMatch(hourRoom -> hourRoom.getHourInterval().getDay().equals(day)))
                .collect(Collectors.toList());
    }

    public static Optional<Integer> dayDisponibility(Student student,String day){
        return Optional.of(filterbyDay(student, day).stream()
                .flatMap(c -> c.getHourRoom().stream())
                .filter(hourRoom -> hourRoom.getHourInterval().getDay().equals(day))
                .mapToInt(hourRoom -> hourRoom.getHourInterval().getIntervalEnd().getHour()
                        - hourRoom.getHourInterval().getIntervalBegin().getHour()).sum());
    }

    public static Optional<List<RoomHour>> studentDisponibility(HourInterval hourInterval,Student student){
        List<RoomHour> cc=filterbyDay(student,hourInterval.getDay()).stream()
                .flatMap(curso -> curso.getHourRoom().stream())
                    .filter(hourRoom -> hourRoom.getHourInterval().getDay().equals(hourInterval.getDay()))
                        .toList();
        List<RoomHour> coursesWithTime =cc.stream().filter(x-> TimeOperator.isIn(hourInterval,x.getHourInterval()))
                .collect(Collectors.toList());
        return Optional.of(coursesWithTime);
    }

    public static Optional<List<RoomHour>> studentBeforeDisponibility(HourInterval hourInterval,Student student){
        List<RoomHour> cc=filterbyDay(student,hourInterval.getDay()).stream()
                .flatMap(curso -> curso.getHourRoom().stream())
                .filter(hourRoom -> hourRoom.getHourInterval().getDay().equals(hourInterval.getDay()))
                .toList();
        List<RoomHour> coursesEndBegin =cc.stream().filter(x-> TimeOperator.isBefore(x.getHourInterval(),hourInterval))
                .collect(Collectors.toList());
        return Optional.of(coursesEndBegin);
    }

    public static Integer sumTeacherDisponibility(Course course){
        return course.getTeacher().getHour_interval().stream().mapToInt(x->x.getIntervalEnd().getHour()-x.getIntervalBegin().getHour()).sum();
    }



}
