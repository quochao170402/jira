package cybersoft.javabackend.java18.jira.role.model;

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
@Table(name = RoleEntity.Operation.TABLE_NAME)
@Getter
@Setter
@SuperBuilder

@AllArgsConstructor
@NoArgsConstructor
public class Operation extends BaseEntity {
    @Column(name = RoleEntity.Operation.NAME, unique = true)
    private String name;

    @Column(name = RoleEntity.Operation.CODE, unique = true)
    private String code;

    @Column(name = RoleEntity.Operation.DESCRIPTION)
    private String description;

    @Column(name = RoleEntity.Operation.TYPE, nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToMany(
            mappedBy = RoleEntity.RoleMappedOperation.OPERATION_MAPPED_ROLE
    )
    private Set<Role> roles = new LinkedHashSet<>();

    public enum Type {
        SAVE_OR_UPDATE,
        FETCH,
        REMOVE
    }
}
