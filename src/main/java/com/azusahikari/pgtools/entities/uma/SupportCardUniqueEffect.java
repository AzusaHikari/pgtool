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
@Table(name = "support_card_unique_effect")
public class SupportCardUniqueEffect {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "lv", nullable = false)
    private String lv;
    @Column(name = "type_0", nullable = false)
    private String type0;
    @Column(name = "value_0", nullable = false)
    private String value0;
    @Column(name = "type_1", nullable = false)
    private String type1;
    @Column(name = "value_1", nullable = false)
    private String value1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SupportCardUniqueEffect that = (SupportCardUniqueEffect) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
