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
@IdClass(SupportCardEffectTablePK.class)
@Table(name = "support_card_effect_table", indexes = {@Index(name = "support_card_effect_table_0_id", columnList = "id")})
public class SupportCardEffectTable {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Id
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "init", nullable = false)
    private String init;
    @Column(name = "limit_lv5", nullable = false)
    private String limitLv5;
    @Column(name = "limit_lv10", nullable = false)
    private String limitLv10;
    @Column(name = "limit_lv15", nullable = false)
    private String limitLv15;
    @Column(name = "limit_lv20", nullable = false)
    private String limitLv20;
    @Column(name = "limit_lv25", nullable = false)
    private String limitLv25;
    @Column(name = "limit_lv30", nullable = false)
    private String limitLv30;
    @Column(name = "limit_lv35", nullable = false)
    private String limitLv35;
    @Column(name = "limit_lv40", nullable = false)
    private String limitLv40;
    @Column(name = "limit_lv45", nullable = false)
    private String limitLv45;
    @Column(name = "limit_lv50", nullable = false)
    private String limitLv50;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SupportCardEffectTable that = (SupportCardEffectTable) o;
        return id != null && Objects.equals(id, that.id)
                && type != null && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}
