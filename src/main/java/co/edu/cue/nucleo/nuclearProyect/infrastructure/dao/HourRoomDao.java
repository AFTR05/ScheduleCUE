package co.edu.cue.nucleo.nuclearProyect.infrastructure.dao;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Course;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.HourInterval;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Room;

public interface HourRoomDao {
    void createWithAtt(HourInterval hourInterval, Room room, Course course);
}
