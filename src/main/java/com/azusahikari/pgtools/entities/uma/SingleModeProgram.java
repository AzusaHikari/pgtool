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
@Table(name = "single_mode_program", indexes = {@Index(name = "single_mode_program_0_month", columnList = "month")})
public class SingleModeProgram {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "base_program_id", nullable = false)
    private String baseProgramId;
    @Column(name = "program_group", nullable = false)
    private String programGroup;
    @Column(name = "race_instance_id", nullable = false)
    private String raceInstanceId;
    @Column(name = "race_permission", nullable = false)
    private String racePermission;
    @Column(name = "month", nullable = false)
    private String month;
    @Column(name = "half", nullable = false)
    private String half;
    @Column(name = "grade_rate_id", nullable = false)
    private String gradeRateId;
    @Column(name = "entry_decrease", nullable = false)
    private String entryDecrease;
    @Column(name = "entry_decrease_flag", nullable = false)
    private String entryDecreaseFlag;
    @Column(name = "recommend_class_id", nullable = false)
    private String recommendClassId;
    @Column(name = "filly_only_flag", nullable = false)
    private String fillyOnlyFlag;
    @Column(name = "need_fan_count", nullable = false)
    private String needFanCount;
    @Column(name = "fan_set_id", nullable = false)
    private String fanSetId;
    @Column(name = "reward_set_id", nullable = false)
    private String rewardSetId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SingleModeProgram that = (SingleModeProgram) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
