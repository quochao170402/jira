package cybersoft.javabackend.java18.jira.role.boundary;

import cybersoft.javabackend.java18.jira.common.constant.UrlConstant;
import cybersoft.javabackend.java18.jira.common.utils.ResponseUtils;
import cybersoft.javabackend.java18.jira.role.dto.UserGroupDTO;
import cybersoft.javabackend.java18.jira.role.model.UserGroup;
import cybersoft.javabackend.java18.jira.role.service.UserGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(UrlConstant.USER_GROUP_URL)
public class UserGroupRestSource {
    private final UserGroupService service;

    public UserGroupRestSource(UserGroupService service) {
        this.service = service;
    }

    @GetMapping
    public Object findAll() {
        return ResponseUtils.get(
                service.findAllDto(UserGroupDTO.class),
                HttpStatus.OK);
    }

    @GetMapping("/include-users")
    public Object findAllUserGroupIncludeUsers() {
        return ResponseUtils.get(
//                service.findDtoById(groupId, UserGroupWithUsersDTO.class),
                service.findAllUserGroupIncludeUser(),
                HttpStatus.OK);
    }

    @PostMapping
    public Object save(@RequestBody @Valid UserGroupDTO dto) {
        return ResponseUtils.get(service.save(dto, UserGroup.class, UserGroupDTO.class),
                HttpStatus.OK);
    }

    @PostMapping("/{group-id}/add-users")
    public Object addUsersToGroup(@PathVariable(name = "group-id") UUID groupId,@RequestBody List<UUID> ids) {
        return ResponseUtils.get(
                service.addUserToGroup(groupId, ids),
                HttpStatus.CREATED
        );
    }
}
