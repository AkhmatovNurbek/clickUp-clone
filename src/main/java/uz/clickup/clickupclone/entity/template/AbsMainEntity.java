package uz.clickup.clickupclone.entity.template;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import uz.clickup.clickupclone.entity.AuthUser;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbsMainEntity {
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
    @JoinColumn(updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private AuthUser createdBy;
    @ManyToOne(fetch = FetchType.LAZY)
    private AuthUser updatedBy;



}
