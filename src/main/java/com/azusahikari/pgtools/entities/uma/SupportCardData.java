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
@Table(name = "support_card_data", indexes = {@Index(name = "support_card_data_0_chara_id", columnList = "chara_id")})
public class SupportCardData {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "chara_id", nullable = false)
    private String charaId;
    @Column(name = "rarity", nullable = false)
    private String rarity;
    @Column(name = "exchange_item_id", nullable = false)
    private String exchangeItemId;
    @Column(name = "effect_table_id", nullable = false)
    private String effectTableId;
    @Column(name = "unique_effect_id", nullable = false)
    private String uniqueEffectId;
    @Column(name = "command_type", nullable = false)
    private String commandType;
    @Column(name = "command_id", nullable = false)
    private String commandId;
    @Column(name = "support_card_type", nullable = false)
    private String supportCardType;
    @Column(name = "skill_set_id", nullable = false)
    private String skillSetId;
    @Column(name = "detail_pos_x", nullable = false)
    private String detailPosX;
    @Column(name = "detail_pos_y", nullable = false)
    private String detailPosY;
    @Column(name = "detail_scale", nullable = false)
    private String detailScale;
    @Column(name = "detail_rot_z", nullable = false)
    private String detailRotZ;
    @Column(name = "start_date", nullable = false)
    private String startDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SupportCardData that = (SupportCardData) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
