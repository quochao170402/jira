package cybersoft.javabackend.java18.jira.security.dto;

import cybersoft.javabackend.java18.jira.security.validation.MustBeExistedUser;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    @MustBeExistedUser
    private String username;
    private String password;
}
