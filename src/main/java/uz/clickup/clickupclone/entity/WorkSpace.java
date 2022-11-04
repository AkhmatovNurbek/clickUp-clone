package uz.clickup.clickupclone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.clickup.clickupclone.entity.template.AbLongEntity;
import uz.clickup.clickupclone.entity.template.AbsUUIDEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkSpace extends AbLongEntity {
    @Column(nullable = false)
    private String name;
    private String color;
    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    private AuthUser owner_id;
    private String initialLetter;
    @ManyToOne(fetch = FetchType.LAZY)
    private Attachment avatar;

}
