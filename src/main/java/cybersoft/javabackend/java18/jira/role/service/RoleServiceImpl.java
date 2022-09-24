package cybersoft.javabackend.java18.jira.role.service;

import cybersoft.javabackend.java18.jira.common.utils.JiraMapper;
import cybersoft.javabackend.java18.jira.role.model.Role;
import cybersoft.javabackend.java18.jira.role.repository.RoleRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final JiraMapper mapper;

    public RoleServiceImpl(RoleRepository roleRepository, JiraMapper mapper) {
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }

    @Override
    public Role update(Role role, String code) {
        /*
            1. Get entity from database by repository -> object will place in orm context
            2. Change object -> when finish transaction, data will update to database
            3. Use repository.save(object) to save object with new data to database
         */
        Role currentRole = roleRepository.findByCode(code);

        if (currentRole == null) return null;
        currentRole.setName(role.getName());
        currentRole.setDescription(role.getDescription());

        return roleRepository.save(currentRole);
    }

    @Override
    public void delete(String code) {
        Role currentRole = roleRepository.findByCode(code);
        if (currentRole == null) return;
        roleRepository.deleteByCode(code);
    }

    @Override
    public JpaRepository<Role, UUID> getRepository() {
        return this.roleRepository;
    }

    @Override
    public JiraMapper getMapper() {
        return mapper;
    }
}
