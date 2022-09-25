package cybersoft.javabackend.java18.jira.role.service;

import cybersoft.javabackend.java18.jira.common.service.GenericService;
import cybersoft.javabackend.java18.jira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.jira.role.model.Role;

import java.util.List;
import java.util.UUID;

public interface RoleService extends GenericService<Role, RoleDTO, UUID> {
    RoleDTO save(RoleDTO roleDTO);

    List<RoleDTO> findAll();

    RoleDTO update(RoleDTO roleDTO, String code);
    void delete(String code);

}
