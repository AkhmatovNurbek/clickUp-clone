package uz.clickup.clickupclone.entity;

import lombok.*;
import org.hibernate.Hibernate;
import uz.clickup.clickupclone.entity.enums.WorkspaceRoleName;
import uz.clickup.clickupclone.entity.template.AbLongEntity;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkSpaceRole extends AbLongEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private WorkSpace workSpace;
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private WorkspaceRoleName extendsRole;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        WorkSpaceRole that = (WorkSpaceRole) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
