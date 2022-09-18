package cybersoft.javabackend.java18.jira.role.service;

import cybersoft.javabackend.java18.jira.role.model.RoleModel;

import java.util.List;

public interface RoleService {
    List<RoleModel> findAll();
    RoleModel findByCode(String code);
    RoleModel save(RoleModel roleModel);
    RoleModel update(RoleModel roleModel, String code);
    void delete(String code);

}
