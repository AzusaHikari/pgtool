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
@Table(name = "race", indexes = {@Index(name = "race_0_course_set", columnList = "course_set"),
        @Index(name = "race_0_group", columnList = "'group'")})
public class Race {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "'group'", nullable = false)
    private String group;
    @Column(name = "grade", nullable = false)
    private String grade;
    @Column(name = "course_set", nullable = false)
    private String courseSet;
    @Column(name = "thumbnail_id", nullable = false)
    private String thumbnailId;
    @Column(name = "ff_cue_name", nullable = false)
    private String ffCueName;
    @Column(name = "ff_cuesheet_name", nullable = false)
    private String ffCuesheetName;
    @Column(name = "ff_anim", nullable = false)
    private String ffAnim;
    @Column(name = "ff_camera", nullable = false)
    private String ffCamera;
    @Column(name = "ff_camera_sub", nullable = false)
    private String ffCameraSub;
    @Column(name = "ff_sub", nullable = false)
    private String ffSub;
    @Column(name = "goal_gate", nullable = false)
    private String goalGate;
    @Column(name = "goal_flower", nullable = false)
    private String goalFlower;
    @Column(name = "audience", nullable = false)
    private String audience;
    @Column(name = "entry_num", nullable = false)
    private String entryNum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Race race = (Race) o;
        return id != null && Objects.equals(id, race.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
