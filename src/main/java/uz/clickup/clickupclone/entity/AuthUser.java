package uz.clickup.clickupclone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.clickup.clickupclone.entity.enums.SystemRoleName;
import uz.clickup.clickupclone.entity.template.AbsUUIDEntity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AuthUser extends AbsUUIDEntity implements UserDetails {
    private String fullName;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String color;
    private String initialLetter;
    @OneToOne(fetch = FetchType.LAZY)
    private Attachment avatar;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    @Enumerated(EnumType.STRING)
    private SystemRoleName systemRoleName;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(this.systemRoleName.name());
        
        return Arrays.asList(simpleGrantedAuthority);
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
