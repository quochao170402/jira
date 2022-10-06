package cybersoft.javabackend.java18.jira.role.model;

import cybersoft.javabackend.java18.jira.common.constant.RoleEntityConstant;
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
@Table(name = RoleEntityConstant.Module.TABLE_NAME)
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Module extends BaseEntity {
    @Column(name = RoleEntityConstant.Module.NAME,unique = true)
    private String name;

    @Column(name = RoleEntityConstant.Module.CODE,unique = true)
    private String code;

    @Column(name = RoleEntityConstant.Module.DESCRIPTION)
    private String description;
}
