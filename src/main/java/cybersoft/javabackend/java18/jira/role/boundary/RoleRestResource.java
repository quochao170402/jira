package cybersoft.javabackend.java18.jira.role.boundary;

import cybersoft.javabackend.java18.jira.common.utils.ResponseUtils;
import cybersoft.javabackend.java18.jira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.jira.role.model.Role;
import cybersoft.javabackend.java18.jira.role.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleRestResource {
    private final RoleService roleService;

    public RoleRestResource(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public Object findAll() {
        return ResponseUtils.get(roleService.findAllDto(RoleDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public Object saveRole(@RequestBody Role role) {
        return ResponseUtils.get(roleService.save(role), HttpStatus.CREATED);
    }

    @PutMapping("/{code}")
    public Object updateRole(@RequestBody Role role, @PathVariable String code) {
        return ResponseUtils.get(roleService.update(role, code), HttpStatus.CREATED);
    }

    @DeleteMapping("/{code}")
    public Object deleteRole(@PathVariable String code) {
        roleService.delete(code);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
