package cybersoft.javabackend.java18.jira.user.dto;

import cybersoft.javabackend.java18.jira.user.model.User;
import cybersoft.javabackend.java18.jira.user.validation.annotation.UniqueUser;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@UniqueUser
public class UserDTO {
    private UUID id;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String avatar;
    private String displayName;
    private User.Status status;
    private String facebookUrl;
    private String majority;
    private String department;
    private String hobbies;
}
