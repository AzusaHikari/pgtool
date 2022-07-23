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
@Table(name = "skill_data", indexes = {@Index(name = "skill_data_0_group_id", columnList = "group_id")})
public class SkillData {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "rarity", nullable = false)
    private String rarity;
    @Column(name = "group_id", nullable = false)
    private String groupId;
    @Column(name = "group_rate", nullable = false)
    private String groupRate;
    @Column(name = "filter_switch", nullable = false)
    private String filterSwitch;
    @Column(name = "grade_value", nullable = false)
    private String gradeBalue;
    @Column(name = "skill_category", nullable = false)
    private String skillCategory;
    @Column(name = "tag_id", nullable = false)
    private String tagId;
    @Column(name = "unique_skill_id_1", nullable = false)
    private String uniqueSkillId1;
    @Column(name = "unique_skill_id_2", nullable = false)
    private String uniqueSkillId2;
    @Column(name = "exp_type", nullable = false)
    private String expType;
    @Column(name = "potential_per_default", nullable = false)
    private String potentialPerDefault;
    @Column(name = "activate_lot", nullable = false)
    private String activateLot;
    @Column(name = "condition_1", nullable = false)
    private String condition1;
    @Column(name = "float_ability_time_1", nullable = false)
    private String floatAbilityTime1;
    @Column(name = "float_cooldown_time_1", nullable = false)
    private String floatCooldownTime1;
    @Column(name = "ability_type_1_1", nullable = false)
    private String abilityType11;
    @Column(name = "ability_value_usage_1_1", nullable = false)
    private String abilityValueUsage11;
    @Column(name = "ability_value_level_usage_1_1", nullable = false)
    private String abilityValueLevelUsage11;
    @Column(name = "float_ability_value_1_1", nullable = false)
    private String floatAbilityValue11;
    @Column(name = "target_type_1_1", nullable = false)
    private String targetType11;
    @Column(name = "target_value_1_1", nullable = false)
    private String targetValue11;
    @Column(name = "ability_type_1_2", nullable = false)
    private String abilityType12;
    @Column(name = "ability_value_usage_1_2", nullable = false)
    private String abilityValueUsage12;
    @Column(name = "ability_value_level_usage_1_2", nullable = false)
    private String abilityValueLevelUsage12;
    @Column(name = "float_ability_value_1_2", nullable = false)
    private String floatAbilityValue12;
    @Column(name = "target_type_1_2", nullable = false)
    private String targetType12;
    @Column(name = "target_value_1_2", nullable = false)
    private String targetValue12;
    @Column(name = "ability_type_1_3", nullable = false)
    private String abilityType13;
    @Column(name = "ability_value_usage_1_3", nullable = false)
    private String abilityValueUsage13;
    @Column(name = "ability_value_level_usage_1_3", nullable = false)
    private String abilityValueLevelUsage13;
    @Column(name = "float_ability_value_1_3", nullable = false)
    private String floatAbilityValue13;
    @Column(name = "target_type_1_3", nullable = false)
    private String targetType13;
    @Column(name = "target_value_1_3", nullable = false)
    private String targetValue13;
    @Column(name = "condition_2", nullable = false)
    private String condition2;
    @Column(name = "float_ability_time_2", nullable = false)
    private String floatAbilityTime2;
    @Column(name = "float_cooldown_time_2", nullable = false)
    private String floatCooldownTime2;
    @Column(name = "ability_type_2_1", nullable = false)
    private String abilityType21;
    @Column(name = "ability_value_usage_2_1", nullable = false)
    private String abilityValueUsage21;
    @Column(name = "ability_value_level_usage_2_1", nullable = false)
    private String abilityValueLevelUsage21;
    @Column(name = "float_ability_value_2_1", nullable = false)
    private String floatAbilityValue21;
    @Column(name = "target_type_2_1", nullable = false)
    private String targetType21;
    @Column(name = "target_value_2_1", nullable = false)
    private String targetValue21;
    @Column(name = "ability_type_2_2", nullable = false)
    private String abilityType22;
    @Column(name = "ability_value_usage_2_2", nullable = false)
    private String abilityValueUsage22;
    @Column(name = "ability_value_level_usage_2_2", nullable = false)
    private String abilityValueLevelUsage22;
    @Column(name = "float_ability_value_2_2", nullable = false)
    private String floatAbilityValue22;
    @Column(name = "target_type_2_2", nullable = false)
    private String targetType22;
    @Column(name = "target_value_2_2", nullable = false)
    private String targetValue22;
    @Column(name = "ability_type_2_3", nullable = false)
    private String abilityType23;
    @Column(name = "ability_value_usage_2_3", nullable = false)
    private String abilityValueUsage23;
    @Column(name = "ability_value_level_usage_2_3", nullable = false)
    private String abilityValueLevelUsage23;
    @Column(name = "float_ability_value_2_3", nullable = false)
    private String floatAbilityValue23;
    @Column(name = "target_type_2_3", nullable = false)
    private String targetType23;
    @Column(name = "target_value_2_3", nullable = false)
    private String targetValue23;
    @Column(name = "popularity_add_param_1", nullable = false)
    private String popularityAddParam1;
    @Column(name = "popularity_add_value_1", nullable = false)
    private String popularityAddValue1;
    @Column(name = "popularity_add_param_2", nullable = false)
    private String popularityAddParam2;
    @Column(name = "popularity_add_value_2", nullable = false)
    private String popularityAddValue2;
    @Column(name = "disp_order", nullable = false)
    private String dispOrder;
    @Column(name = "icon_id", nullable = false)
    private String iconId;
    @Column(name = "plate_type", nullable = false)
    private String plateType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SkillData skillData = (SkillData) o;
        return id != null && Objects.equals(id, skillData.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
