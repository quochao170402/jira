package cybersoft.javabackend.java18.jira.role.model;

import cybersoft.javabackend.java18.jira.common.model.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = RoleEntity.UserGroup.TABLE_NAME)
@Getter
@Setter
@SuperBuilder

@AllArgsConstructor
@NoArgsConstructor
public class UserGroup extends BaseEntity {
    @Column(name = RoleEntity.UserGroup.NAME, unique = true)
    private String name;

    @Column(name = RoleEntity.UserGroup.CODE, unique = true)
    private String code;

    @Column(name = RoleEntity.UserGroup.DESCRIPTION)
    private String description;
}
