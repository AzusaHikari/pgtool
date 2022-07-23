package com.azusahikari.pgtools.entities.uma;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "race_course_set", indexes = {@Index(name = "race_course_set_0_race_track_id", columnList = "race_track_id")})
public class RaceCourseSet {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "race_track_id", nullable = false)
    private String raceTrackId;
    @Column(name = "distance", nullable = false)
    private String distance;
    @Column(name = "ground", nullable = false)
    private String ground;
    @Column(name = "inout", nullable = false)
    private String inout;
    @Column(name = "turn", nullable = false)
    private String turn;
    @Column(name = "fence_set", nullable = false)
    private String fenceSet;
    @Column(name = "float_lane_max", nullable = false)
    private String floatLaneMax;
    @Column(name = "course_set_status_id", nullable = false)
    private String courseSetStatusId;
    @Column(name = "finish_time_min", nullable = false)
    private String finishTimeMin;
    @Column(name = "finish_time_min_random_range", nullable = false)
    private String finishTimeMinRandomRange;
    @Column(name = "finish_time_max", nullable = false)
    private String finishTimeMax;
    @Column(name = "finish_time_max_random_range", nullable = false)
    private String finishTimeMaxRandomRange;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RaceCourseSet that = (RaceCourseSet) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
