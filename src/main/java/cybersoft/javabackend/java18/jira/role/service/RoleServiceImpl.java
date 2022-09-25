package cybersoft.javabackend.java18.jira.role.service;

import cybersoft.javabackend.java18.jira.common.utils.JiraMapper;
import cybersoft.javabackend.java18.jira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.jira.role.model.Role;
import cybersoft.javabackend.java18.jira.role.repository.RoleRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public RoleDTO save(RoleDTO dto) {
        return RoleService.super.save(dto, Role.class, RoleDTO.class);
    }

    @Override
    public List<RoleDTO> findAll() {
        return RoleService.super.findAll(RoleDTO.class);
    }

    @Override
    public RoleDTO update(RoleDTO role, String code) {
        /*
            1. Get entity from database by repository -> object will place in orm context
            2. Change object -> when finish transaction, data will update to database
            3. Use repository.save(object) to save object with new data to database
         */
        Role currentRole = roleRepository.findByCode(code);

        if (currentRole == null) return null;
        currentRole.setName(role.getName());
        currentRole.setDescription(role.getDescription());

        return getMapper().map(RoleService.super.update(currentRole, currentRole.getId()), RoleDTO.class);
    }

    @Override
    public RoleDTO update(RoleDTO roleDTO, String code) {
        Role currentRole = roleRepository.findByCode(code);
        if (currentRole == null) return null;
        currentRole.setName(roleDTO.getName());
        currentRole.setDescription(roleDTO.getDescription());
        return mapper.map(roleRepository.save(currentRole), RoleDTO.class);
    }

    @Override
    public void delete(String code) {
        Role currentRole = roleRepository.findByCode(code);
        if (currentRole == null) return;
        roleRepository.deleteByCode(code);
    }

    @Override
    public RoleDTO save(RoleDTO dto) {
        Role entity = mapper.map(dto, Role.class);
        return mapper.map(RoleService.super.save(entity), RoleDTO.class);
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
