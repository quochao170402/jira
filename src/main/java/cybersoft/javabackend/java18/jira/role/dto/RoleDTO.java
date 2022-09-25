package cybersoft.javabackend.java18.jira.role.dto;

import cybersoft.javabackend.java18.jira.role.validation.annotation.UniqueRole;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
// Can set annotation in class -> target is class
@UniqueRole(message = "{role.existed}")
public class RoleDTO {
    @Length(min = 5, max = 100, message = "Role name must have length between {min} and {max}")
    @NotBlank
    private String name;

    @Length(min = 3, max = 10, message = "Role code must have length between {min} and {max}")
    @NotBlank
    private String code;

    @NotBlank( message = "Role description can not be blank")
    private String description;
}
