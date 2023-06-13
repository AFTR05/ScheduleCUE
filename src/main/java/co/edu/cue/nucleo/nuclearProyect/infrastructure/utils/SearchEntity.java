package co.edu.cue.nucleo.nuclearProyect.infrastructure.utils;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.*;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.Modality;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.Program;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.HourIntervalDao;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.HourRoomDao;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl.DurationDaoImpl;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.impl.ProgramSemesterImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class SearchEntity {
    public static ProgramSemester getProgramSemester(String program,
                                                     String modality,
                                                     String semester,ObjectDao<Modality> modalityDao,ObjectDao<Program> programDao,
                                                     ProgramSemesterImpl programSemesterDao){
        Optional<ProgramSemester> ops=programSemesterDao.byProps(modality, semester, program);
        if (ops.isPresent()){
            return ops.get();
        }
        Modality mod=modalityDao.byName(modality);
        Program pro=programDao.byName(program);
        programSemesterDao.createWithAtt(mod,semester,pro);
        return programSemesterDao.byProps(mod.getModality(),semester,pro.getName()).get();
    }

    public static Duration getDuration(String begin, String end, DurationDaoImpl durationDao){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate beginDate = LocalDate.parse(begin, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);
        Optional<Duration> ops=durationDao.byProps(beginDate,endDate);
        if (ops.isPresent()){
            return ops.get();
        }
        durationDao.save(createByProps(beginDate,endDate));
        return durationDao.byProps(beginDate,endDate).get();
    }

    public static void createHourRooms(Course course, HourRoomDao hourRoomDao,HourIntervalDao hourIntervalDao){
/*        course.getHourRoom().stream().forEach(r->{
            HourInterval hi=getHourInterval(r.getHourInterval().getDay(),r.getHourInterval().getIntervalBegin()
                    ,r.getHourInterval().getIntervalEnd(),hourIntervalDao);
            r.setId(r.getHourInterval().getIntervalBegin()+"-"+r.getHourInterval().getIntervalEnd()+"-"+r.getRoom().getName()+"-"+course.getId());
            hourRoomDao.createWithAtt(hi,r.getRoom(),course);
        });*/
        for (RoomHour r:course.getHourRoom()) {
            HourInterval hi=getHourInterval(r.getHourInterval().getDay(),r.getHourInterval().getIntervalBegin()
                    , r.getHourInterval().getIntervalEnd(),hourIntervalDao);
            hourRoomDao.createWithAtt(hi,r.getRoom(),course);
        }
    }

    public static Duration createByProps(LocalDate beginDate, LocalDate endDate){
        String id=beginDate.toString()+"-"+endDate.toString();
        return new Duration(id,beginDate,endDate);
    }

        public static HourInterval getHourInterval(String day, LocalTime begin, LocalTime end,HourIntervalDao hourIntervalDao){
            Optional<HourInterval> hi=hourIntervalDao.byProps(day,begin,end);
            if (hi.isPresent()){
                return hi.get();
            }
            hourIntervalDao.createWithNoID(day,begin.toString()+":00",end.toString()+":00");
            return hourIntervalDao.byProps(day,begin,end).get();
        }
}
