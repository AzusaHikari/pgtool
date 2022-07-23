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
@Table(name = "chara_data")
public class CharaDate {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "birth_year", nullable = false)
    private String birthYear;
    @Column(name = "birth_month", nullable = false)
    private String birthMonth;
    @Column(name = "birth_day", nullable = false)
    private String birthDay;
    @Column(name = "sex", nullable = false)
    private String sex;
    @Column(name = "image_color_main", nullable = false)
    private String imageColorMain;
    @Column(name = "image_color_sub", nullable = false)
    private String imageColorSub;
    @Column(name = "ui_color_main", nullable = false)
    private String uiColorMain;
    @Column(name = "ui_color_sub", nullable = false)
    private String uiColorSub;
    @Column(name = "ui_training_color_1", nullable = false)
    private String uiTrainingColor1;
    @Column(name = "ui_training_color_2", nullable = false)
    private String uiTrainingColor2;
    @Column(name = "ui_border_color", nullable = false)
    private String uiBorderColor;
    @Column(name = "ui_num_color_1", nullable = false)
    private String uiNumColor1;
    @Column(name = "ui_num_color_2", nullable = false)
    private String uiNumColor2;
    @Column(name = "ui_turn_color", nullable = false)
    private String uiTurnColor;
    @Column(name = "ui_wipe_color_1", nullable = false)
    private String uiWipeColor1;
    @Column(name = "ui_wipe_color_2", nullable = false)
    private String uiWipeColor2;
    @Column(name = "ui_wipe_color_3", nullable = false)
    private String uiWipeColor3;
    @Column(name = "ui_speech_color_1", nullable = false)
    private String uiSpeechColor1;
    @Column(name = "ui_speech_color_2", nullable = false)
    private String uiSpeechColor2;
    @Column(name = "ui_nameplate_color_1", nullable = false)
    private String uiNameplateColor1;
    @Column(name = "ui_nameplate_color_2", nullable = false)
    private String uiNameplateColor2;
    @Column(name = "height", nullable = false)
    private String height;
    @Column(name = "bust", nullable = false)
    private String bust;
    @Column(name = "scale", nullable = false)
    private String scale;
    @Column(name = "skin", nullable = false)
    private String skin;
    @Column(name = "shape", nullable = false)
    private String shape;
    @Column(name = "socks", nullable = false)
    private String socks;
    @Column(name = "personal_dress", nullable = false)
    private String personalDress;
    @Column(name = "tail_model_id", nullable = false)
    private String tailModelId;
    @Column(name = "race_running_type", nullable = false)
    private String raceRunningType;
    @Column(name = "ear_random_time_min", nullable = false)
    private String earRandomTimeMin;
    @Column(name = "ear_random_time_max", nullable = false)
    private String earRandomTimeMax;
    @Column(name = "tail_random_time_min", nullable = false)
    private String tailRandomTimeMin;
    @Column(name = "tail_random_time_max", nullable = false)
    private String tailRandomTimeMax;
    @Column(name = "story_ear_random_time_min", nullable = false)
    private String storyEarRandomTimeMin;
    @Column(name = "story_ear_random_time_max", nullable = false)
    private String storyEarRandomTimeMax;
    @Column(name = "story_tail_random_time_min", nullable = false)
    private String storyTailRandomTimeMin;
    @Column(name = "story_tail_random_time_max", nullable = false)
    private String storyTailRandomTimeMax;
    @Column(name = "attachment_model_id", nullable = false)
    private String attachmentModelId;
    @Column(name = "mini_mayu_shader_type", nullable = false)
    private String miniMayuShaderType;
    @Column(name = "start_date", nullable = false)
    private String startDate;
    @Column(name = "chara_category", nullable = false)
    private String charaCategory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CharaDate charaDate = (CharaDate) o;
        return id != null && Objects.equals(id, charaDate.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
