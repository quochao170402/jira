package cybersoft.javabackend.java18.jira.user.boundary;

import cybersoft.javabackend.java18.jira.common.constant.UrlConstant;
import cybersoft.javabackend.java18.jira.common.utils.ResponseUtils;
import cybersoft.javabackend.java18.jira.user.dto.UserDTO;
import cybersoft.javabackend.java18.jira.user.model.User;
import cybersoft.javabackend.java18.jira.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(UrlConstant.USER_URL)
public class UserRestSource {
    private final UserService userService;

    public UserRestSource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Object findAll(){
        return ResponseUtils.get(
                userService.findAllDto(UserDTO.class),
                HttpStatus.OK);
    }

    @PostMapping
    public Object saveUser(@RequestBody @Valid UserDTO userDTO){
        return ResponseUtils.get(
                userService.save(userDTO, User.class, UserDTO.class),
                HttpStatus.CREATED);
    }
}
