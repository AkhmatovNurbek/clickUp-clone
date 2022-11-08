package uz.clickup.clickupclone.entity;

import lombok.*;
import org.hibernate.Hibernate;
import uz.clickup.clickupclone.entity.template.AbLongEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkSpace extends AbLongEntity {
    @Column(nullable = false)
    private String name;
    private String color;
    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    private AuthUser owner;
    @Column(nullable = false)
    private String initialLetter;
    @ManyToOne(fetch = FetchType.LAZY)
    private Attachment avatar;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        WorkSpace workSpace = (WorkSpace) o;
        return getId() != null && Objects.equals(getId(), workSpace.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
