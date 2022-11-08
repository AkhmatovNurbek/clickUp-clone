package uz.clickup.clickupclone.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.clickup.clickupclone.entity.enums.SystemRoleName;
import uz.clickup.clickupclone.entity.template.AbLongEntity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AuthUser extends AbLongEntity implements UserDetails {
    private String fullName;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String color;
    private String initialLetter;
    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Attachment avatar;
    private String emailCode;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AuthUser authUser = (AuthUser) o;
        return getId() != null && Objects.equals(getId(), authUser.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public AuthUser(String fullName, String email, String password, SystemRoleName systemRoleName) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.systemRoleName = systemRoleName;
    }
}
