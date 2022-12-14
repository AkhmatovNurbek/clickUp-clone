package uz.clickup.clickupclone.entity;

import lombok.*;
import org.hibernate.Hibernate;
import uz.clickup.clickupclone.entity.template.AbLongEntity;

import javax.persistence.Entity;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attachment extends AbLongEntity {
    private String name;
    private String originalName;
    private Long size;
    private String contentType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Attachment that = (Attachment) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
