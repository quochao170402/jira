package cybersoft.javabackend.java18.jira.role.model;

import cybersoft.javabackend.java18.jira.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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

    @Override
    public boolean equals(Object obj) {
        Role other = (Role) obj;
        return super.equals(obj)
                && this.name.equals(other.name)
                && this.code.equals(other.code);
    }
}