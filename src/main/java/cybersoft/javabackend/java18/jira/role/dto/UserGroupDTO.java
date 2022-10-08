package cybersoft.javabackend.java18.jira.role.dto;

import cybersoft.javabackend.java18.jira.role.validation.annotation.UniqueUserGroup;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@UniqueUserGroup
public class UserGroupDTO {
    private UUID id;
    private String name;
    private String code;
    private String description;
}
