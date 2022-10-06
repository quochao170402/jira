package cybersoft.javabackend.java18.jira.role.dto;

import cybersoft.javabackend.java18.jira.user.dto.UserDTO;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserGroupWithUsersDTO {
    private String id;
    private String code;
    private String name;
    private String description;
    private Set<UserDTO> users = new LinkedHashSet<>();
}
