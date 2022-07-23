package com.azusahikari.pgtools.entities.uma;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "single_mode_wins_saddle")
public class SingleModeWinsSaddle {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "priority", nullable = false)
    private String priority;
    @Column(name = "group_id", nullable = false)
    private String groupId;
    @Column(name = "condition", nullable = false)
    private String condition;
    @Column(name = "win_saddle_type", nullable = false)
    private String winSaddleType;
    @Column(name = "race_instance_id_1", nullable = false)
    private String raceInstanceId1;
    @Column(name = "race_instance_id_2", nullable = false)
    private String raceInstanceId2;
    @Column(name = "race_instance_id_3", nullable = false)
    private String raceInstanceId3;
    @Column(name = "race_instance_id_4", nullable = false)
    private String raceInstanceId4;
    @Column(name = "race_instance_id_5", nullable = false)
    private String raceInstanceId5;
    @Column(name = "race_instance_id_6", nullable = false)
    private String raceInstanceId6;
    @Column(name = "race_instance_id_7", nullable = false)
    private String raceInstanceId7;
    @Column(name = "race_instance_id_8", nullable = false)
    private String raceInstanceId8;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SingleModeWinsSaddle that = (SingleModeWinsSaddle) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
