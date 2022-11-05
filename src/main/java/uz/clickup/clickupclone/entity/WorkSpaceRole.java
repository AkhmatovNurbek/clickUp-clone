package uz.clickup.clickupclone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.clickup.clickupclone.entity.WorkSpace;
import uz.clickup.clickupclone.entity.enums.WorkspaceRoleName;
import uz.clickup.clickupclone.entity.template.AbsUUIDEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkSpaceRole extends AbsUUIDEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private WorkSpace workSpace;
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private WorkspaceRoleName extendsRole;




}
