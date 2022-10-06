package cybersoft.javabackend.java18.jira.role.dto;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserGroupDTO {
    private UUID id;
    private String name;
    private String code;
    private String description;
}
