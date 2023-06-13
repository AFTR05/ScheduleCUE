package co.edu.cue.nucleo.nuclearProyect.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

    @Data
    @Entity
    @Table(name="hour_room")
    @NoArgsConstructor
    @AllArgsConstructor
    public class RoomHour {
        @Id
        private String id;
        @ManyToOne
        @JoinColumn(name="hour_interval_id")
        private HourInterval hourInterval;

        @ManyToOne
        @JoinColumn(name="room_id")
        private Room room;
        @ManyToOne
        @JoinColumn(name="course_id")
        @JsonBackReference
        private Course course;

        public RoomHour(HourInterval hourInterval, Room room, Course course) {
            this.hourInterval = hourInterval;
            this.room = room;
            this.course = course;
        }
    }
