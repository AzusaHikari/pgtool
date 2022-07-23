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
@Table(name = "race_instance", indexes = {@Index(name = "race_instance_0_race_id", columnList = "race_id")})
public class RaceInstance {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "race_id", nullable = false)
    private String raceId;
    @Column(name = "npc_group_id", nullable = false)
    private String npcGroupId;
    @Column(name = "date", nullable = false)
    private String date;
    @Column(name = "time", nullable = false)
    private String time;
    @Column(name = "race_number", nullable = false)
    private String raceNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RaceInstance that = (RaceInstance) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
