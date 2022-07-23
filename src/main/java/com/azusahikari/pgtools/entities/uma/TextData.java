package com.azusahikari.pgtools.entities.uma;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


/**
 * category
 * 04-07   角色卡信息
 * 28-38   比賽信息
 * 47-48   技能信息
 * 65-67   成就信息
 * 75-76   支援卡信息
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@IdClass(TextDataPK.class)
@Table(name = "text_data")
public class TextData {
    @Column(name = "id", nullable = false)
    private String id;
    @Id
    @Column(name = "category", nullable = false)
    private String category;
    @Id
    @Column(name = "'index'", nullable = false)
    private String index;
    @Column(name = "text", nullable = false)
    private String text;
    @Column(name = "text_zh")
    private String textZh;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TextData textData = (TextData) o;
        return category != null && Objects.equals(category, textData.category)
                && index != null && Objects.equals(index, textData.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, index);
    }
}
