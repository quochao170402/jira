package cybersoft.javabackend.java18.jira.role.boundary;

import cybersoft.javabackend.java18.jira.common.utils.ResponseUtils;
import cybersoft.javabackend.java18.jira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.jira.role.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public Object saveRole(@RequestBody @Valid RoleDTO roleDTO) {
        return ResponseUtils.get(roleService.save(roleDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{code}")
    public Object updateRole(@RequestBody RoleDTO roleDTO, @PathVariable String code) {
        return ResponseUtils.get(roleService.update(roleDTO, code), HttpStatus.CREATED);
    }

    @DeleteMapping("/{code}")
    public Object deleteRole(@PathVariable String code) {
        roleService.delete(code);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
