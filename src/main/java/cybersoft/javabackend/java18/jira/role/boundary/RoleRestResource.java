package cybersoft.javabackend.java18.jira.role.boundary;

import cybersoft.javabackend.java18.jira.common.constant.UrlConstant;
import cybersoft.javabackend.java18.jira.common.utils.ResponseUtils;
import cybersoft.javabackend.java18.jira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.jira.role.service.RoleService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(UrlConstant.ROLE_URL)
public class RoleRestResource {
    private final RoleService service;

    public RoleRestResource(RoleService roleService){
        this.service = roleService;
    }

    @GetMapping
    public Object findAll(){
        return ResponseUtils.get(service.findAllDto(RoleDTO.class), HttpStatus.OK);
    }

    @GetMapping("/include-operation")
    public Object findAllIncludeOperation(){
        return ResponseUtils.get(
                service.findAllIncludeOperation(),
                HttpStatus.OK
        );
    }

    @GetMapping("/paging")
    public Object findAllDtoPaging(@RequestParam("size") int size,
                                   @RequestParam("index") int index){
        return ResponseUtils.get(
                service.findAllDto(Pageable.ofSize(size).withPage(index), RoleDTO.class)
                , HttpStatus.OK
        );
    }

    @PostMapping
    public Object save(@RequestBody @Valid RoleDTO roleDTO){
        return ResponseUtils.get(service.save(roleDTO), HttpStatus.CREATED);
    }


    @PostMapping("{role-id}/add-operations")
    public Object addOperations(@RequestBody List<UUID> ids,
                                           @PathVariable("role-id") UUID roleId) {
        return ResponseUtils.get(service.addOperations(ids, roleId),
                HttpStatus.OK);
    }
}
