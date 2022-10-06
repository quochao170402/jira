package cybersoft.javabackend.java18.jira.role.dto;

import cybersoft.javabackend.java18.jira.role.validation.annotation.UniqueRole;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@UniqueRole(message = "{role.existed}")
public class RoleDTO {
    private UUID id;
    @Length(min = 5, max = 100, message = "{role.name.size}")
    @NotBlank
    private String name;

    @Length(min = 3, max = 20, message = "{role.code.size}")
    @NotBlank
    private String code;

    @NotBlank( message = "Role description can not be blank")
    private String description;
}
