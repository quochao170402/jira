package cybersoft.javabackend.java18.jira.role.model;

import cybersoft.javabackend.java18.jira.common.constant.RoleEntityConstant;
import cybersoft.javabackend.java18.jira.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = RoleEntityConstant.Operation.TABLE_NAME)
public class Operation extends BaseEntity {
    @Column(name = RoleEntityConstant.Operation.NAME, unique = true)
    private String name;

    @Column(name = RoleEntityConstant.Operation.CODE, unique = true)
    private String code;

    @Column(name = RoleEntityConstant.Operation.DESCRIPTION)
    private String description;

    @Column(name = RoleEntityConstant.Operation.TYPE, nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToMany(
            mappedBy = RoleEntityConstant.RoleMappedOperation.OPERATION_MAPPED_ROLE
    )
    private Set<Role> roles = new LinkedHashSet<>();

    public enum Type {
        SAVE_OR_UPDATE,
        FETCH,
        REMOVE
    }
}




