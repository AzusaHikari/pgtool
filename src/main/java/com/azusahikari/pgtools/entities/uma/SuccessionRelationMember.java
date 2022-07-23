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
@Table(name = "succession_relation_member", indexes = {@Index(name = "succession_relation_member_0_chara_id", columnList = "chara_id")})
public class SuccessionRelationMember {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "relation_type", nullable = false)
    private String relationType;
    @Column(name = "chara_id", nullable = false)
    private String charaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SuccessionRelationMember that = (SuccessionRelationMember) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
