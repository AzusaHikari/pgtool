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
@Table(name = "single_mode_chara_program", indexes = {@Index(name = "single_mode_chara_program_0_chara_id", columnList = "chara_id")})
public class SingleModeCharaProgram {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "chara_id", nullable = false)
    private String charaId;
    @Column(name = "program_group", nullable = false)
    private String programGroup;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SingleModeCharaProgram that = (SingleModeCharaProgram) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
