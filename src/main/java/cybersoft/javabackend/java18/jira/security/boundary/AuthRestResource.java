package cybersoft.javabackend.java18.jira.security.boundary;

import cybersoft.javabackend.java18.jira.common.constant.UrlConstant;
import cybersoft.javabackend.java18.jira.common.utils.ResponseUtils;
import cybersoft.javabackend.java18.jira.security.dto.LoginDTO;
import cybersoft.javabackend.java18.jira.security.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(UrlConstant.AUTH_URL)
public class AuthRestResource {

    private final AuthService authService;

    public AuthRestResource(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Object login(@RequestBody @Valid LoginDTO loginDTO){

        return ResponseUtils.get(
                authService.login(loginDTO),
                HttpStatus.OK
        );
    }
}
