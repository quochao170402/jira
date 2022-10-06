package cybersoft.javabackend.java18.jira.user.model;

import cybersoft.javabackend.java18.jira.common.constant.UserEntityConstant;
import cybersoft.javabackend.java18.jira.common.model.BaseEntity;
import cybersoft.javabackend.java18.jira.role.model.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = UserEntityConstant.User.TABLE_NAME)
public class User extends BaseEntity {
    @Column(name = UserEntityConstant.User.USERNAME
            , unique = true
            , length = 100
            , nullable = false)
    private String username;

    @Column(name = UserEntityConstant.User.PASSWORD
            , length = 100
            , nullable = false)
    private String password;

    @Column(name = UserEntityConstant.User.FULLNAME)
    private String fullname;

    @Column(name = UserEntityConstant.User.EMAIL
            , unique = true
            , length = 100
            , nullable = false)
    private String email;

    @Column(name = UserEntityConstant.User.AVATAR)
    private String avatar;

    @Column(name = UserEntityConstant.User.DISPLAY_NAME)
    private String displayName;

    @Column(name = UserEntityConstant.User.STATUS)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = UserEntityConstant.User.FACEBOOK_URL)
    private String facebookUrl;

    @Column(name = UserEntityConstant.User.MAJORITY)
    private String majority;

    @Column(name = UserEntityConstant.User.DEPARTMENT)
    private String department;

    @Column(name = UserEntityConstant.User.HOBBIES)
    private String hobbies;

    @ManyToMany(mappedBy = UserEntityConstant.UserGroupMappedUser.GROUP_MAPPED_USER)
    private Set<UserGroup> userGroups = new LinkedHashSet<>();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || Hibernate.getClass(this) != Hibernate.getClass(obj)) return false;

        User user = (User) obj;

        if (user.id == null || user.username == null || user.password == null) return false;

        return Objects.equals(this.id, user.id)
                &&
                Objects.equals(this.username, user.username)
                &&
                Objects.equals(this.password, user.password);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public enum Status {
        ACTIVE,
        TEMPORARY_BLOCKED,
        PERMANENT_BLOCKED
    }
}
