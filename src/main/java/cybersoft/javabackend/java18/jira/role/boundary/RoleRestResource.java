package cybersoft.javabackend.java18.jira.role.boundary;

import cybersoft.javabackend.java18.jira.role.model.RoleModel;
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
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Object> findByCode(@PathVariable String code) {
        return new ResponseEntity<>(roleService.findByCode(code), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveRole(@RequestBody RoleModel roleModel) {
        return new ResponseEntity<>(roleService.save(roleModel), HttpStatus.CREATED);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Object> updateRole(@RequestBody RoleModel roleModel, @PathVariable String code) {
        return new ResponseEntity<>(roleService.update(roleModel, code), HttpStatus.CREATED);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Object> deleteRole(@PathVariable String code) {
        roleService.delete(code);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
