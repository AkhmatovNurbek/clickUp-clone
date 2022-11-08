package uz.clickup.clickupclone.entity;

import lombok.*;
import org.hibernate.Hibernate;
import uz.clickup.clickupclone.entity.enums.WorkspacePermissionName;
import uz.clickup.clickupclone.entity.template.AbLongEntity;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkspacePermission extends AbLongEntity {
    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    private WorkSpaceRole workSpaceRole;
    @Enumerated(EnumType.STRING)
    private WorkspacePermissionName permissionName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        WorkspacePermission that = (WorkspacePermission) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
