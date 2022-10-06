package cybersoft.javabackend.java18.jira.role.model;

import cybersoft.javabackend.java18.jira.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = RoleEntity.Role.TABLE_NAME)
public class Role extends BaseEntity {

    @Column(name = RoleEntity.Role.NAME, unique = true)
    @Length(min = 5, max = 100, message = "Role name must have length between {min} and {max}")
    private String name;

    @Column(name = RoleEntity.Role.CODE, unique = true)
    @Length(min = 3, max = 10, message = "Role name must have length between {min} and {max}")
    private String code;

    @Column(name = RoleEntity.Role.DESCRIPTION)
    @NotBlank
    private String description;

    /*  Note
        1. Xac dinh chu trong quan he many to many
        2. Cau hinh quan he 2 chieu
        3. Dong bo trang thai quan he giua 2 entities (cascade)
     */
    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = RoleEntity.RoleMappedOperation.JOIN_TABLE,
            joinColumns = @JoinColumn(name = RoleEntity.RoleMappedOperation.JOIN_TABLE_ROLE_ID),
            inverseJoinColumns = @JoinColumn(name = RoleEntity.RoleMappedOperation.JOIN_TABLE_OPERATION_ID)
    )
    private Set<Operation> operations = new LinkedHashSet<>();

    public void removeService(Operation operation) {
        operations.remove(operation);
        operation.getRoles().remove(this);
    }

    public void addOperation(Operation operation){
        this.operations.add(operation);
        operation.getRoles().add(this);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || Hibernate.getClass(this) != Hibernate.getClass(obj)) return false;

        Role role = (Role) obj;

        return this.id != null && Objects.equals(this.id, role.id);
    }
}
