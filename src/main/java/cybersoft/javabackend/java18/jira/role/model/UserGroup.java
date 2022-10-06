package cybersoft.javabackend.java18.jira.role.model;

import cybersoft.javabackend.java18.jira.common.constant.RoleEntityConstant;
import cybersoft.javabackend.java18.jira.common.constant.UserEntityConstant;
import cybersoft.javabackend.java18.jira.common.model.BaseEntity;
import cybersoft.javabackend.java18.jira.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = RoleEntityConstant.UserGroup.TABLE_NAME)
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserGroup extends BaseEntity {
    @Column(name = RoleEntityConstant.UserGroup.NAME, unique = true)
    private String name;

    @Column(name = RoleEntityConstant.UserGroup.CODE, unique = true)
    private String code;

    @Column(name = RoleEntityConstant.UserGroup.DESCRIPTION)
    private String description;

    public void addUserToGroup(User user) {
        this.getUsers().add(user);
        user.getUserGroups().add(this);
    }

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(name = UserEntityConstant.UserGroupMappedUser.JOIN_TABLE,
            joinColumns = @JoinColumn(name = UserEntityConstant.UserGroupMappedUser.JOIN_TABLE_GROUP_ID),
            inverseJoinColumns = @JoinColumn(name = UserEntityConstant.UserGroupMappedUser.JOIN_TABLE_USER_ID))
    private Set<User> users = new LinkedHashSet<>();

}
