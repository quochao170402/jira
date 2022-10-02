package cybersoft.javabackend.java18.jira.role.model;

import cybersoft.javabackend.java18.jira.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = RoleEntity.Module.TABLE_NAME)
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Module extends BaseEntity {
    @Column(name = RoleEntity.Module.NAME,unique = true)
    private String name;

    @Column(name = RoleEntity.Module.CODE,unique = true)
    private String code;

    @Column(name = RoleEntity.Module.DESCRIPTION)
    private String description;
}
