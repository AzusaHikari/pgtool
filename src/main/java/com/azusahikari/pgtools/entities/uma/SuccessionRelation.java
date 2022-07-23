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
@Table(name = "succession_relation")
public class SuccessionRelation {
    @Id
    @Column(name = "relation_type", nullable = false)
    private String relationType;
    @Column(name = "relation_point", nullable = false)
    private String relationPoint;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SuccessionRelation that = (SuccessionRelation) o;
        return relationType != null && Objects.equals(relationType, that.relationType);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
