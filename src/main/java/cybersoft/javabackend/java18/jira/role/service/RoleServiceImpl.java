package cybersoft.javabackend.java18.jira.role.service;

import cybersoft.javabackend.java18.jira.role.model.RoleModel;
import cybersoft.javabackend.java18.jira.role.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleModel> findAll() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public RoleModel findByCode(String code) {
        return roleRepository.findByCode(code);
    }

    @Override
    public RoleModel save(RoleModel roleModel) {
        return roleRepository.save(roleModel);
    }

    @Override
    public RoleModel update(RoleModel roleModel, String code) {
        RoleModel currentRole = roleRepository.findByCode(code);
        if (currentRole == null) return null;
        currentRole.setName(roleModel.getName());
        currentRole.setDescription(roleModel.getDescription());
        return roleRepository.save(currentRole);
    }

    @Override
    public void delete(String code) {
        roleRepository.deleteByCode(code);
    }
}
