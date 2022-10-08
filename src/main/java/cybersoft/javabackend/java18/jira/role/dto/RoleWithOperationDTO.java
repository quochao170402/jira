package cybersoft.javabackend.java18.jira.role.dto;

import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleWithOperationDTO {
    private UUID id;
    private String name;
    private String code;
    private String description;
    private Set<OperationDTO> operations = new LinkedHashSet<>();
}
